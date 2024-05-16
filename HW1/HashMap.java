package HW1;

public class HashMap<K, V> { // структура хеш-таблицы
    // к - это ключ
    // v - это значение
    // region Публичные Методы
    public V put(K key, V value) {
        if(buckets.length * LOAD_FACTOR <= size){
            recalculate();
        }
        int index = calculateBusketIndex(key);
        Bucket bucket = buckets[index];
        if(bucket == null){
            bucket = new Bucket();
            buckets[index] = bucket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        V buf = (V) bucket.add(entity);
        if(buf == null){
            size++;
        }
        return buf;
    }

    // endregion

    // region Meтоды


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < buckets.length; i++) {
            Bucket<K, V> bucket = buckets[i];
            if (buckets[i] != null){
                Bucket.Node node = bucket.head;
                while (node != null) {
                    stringBuilder.append(node.value.value);
                    stringBuilder.append(node.value.key);
                    stringBuilder.append('\n');
                    node = node.next;
                }
            }
        }
        return stringBuilder.toString();
    }

    private void recalculate(){
        size = 0; // обнуляем размер для корректной работы при добавлении
        // двух элементов в одну ноду
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length*2];
        for(int i = 0; i < old.length; i++){
            Bucket<K,V> bucket = old[i];
            if(bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null){
                    put((K)node.value.key, (V)node.value.value);
                    node = node.next;
                }
            }
        }
    }
    private int calculateBusketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    // берём значение ключа по модулю, чтобы избежать отрицательных значений
        // и остаток от деления на размерность нашего массива
    }

//

//
    // endregion

    // region Конструкторы
    public HashMap(){
        buckets = new Bucket[INIT_BUCKET_COUNT]; // конструктор
    }

    public HashMap(int initCount){
        buckets = new Bucket[initCount];
    }




    // endregion

    // region Вспомогательные структуры



    class Entity{ // элемент хеш-таблицы(объединяет ключ и значение)
        K key;
        V value;

    }
    class Bucket<K,V>{ // элемент массива(связанный список) из которого состоит таблица

        private Node head; // указатель на элемент связного списка
        class Node { // узел связанного списка
            Node next; // ссылка на следующий узел(если имеется)
            Entity value; // значение узла
        }
        public V add(Entity entity){
            Node node = new Node();
            node.value = entity;

            if(head == null) {
                head = node;
                return null;
            }

            Node currentNode = head;
            while (true) {
                if(currentNode.value.key.equals(entity.key)){
                    V buf = (V) currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if(currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                else {
                    currentNode.next = node;
                    return null;
                }
            }
        }
    }
    // endregion

    // region Поля
    private Bucket[] buckets; // массив бакетов (связанных списков)
    private int size;

    // endregion

    // region Константы
    // значение элементов 16, если вызываем конструктор по умолчанию
    private static final int INIT_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.5;
    // фактор расширения

    // endregion
}

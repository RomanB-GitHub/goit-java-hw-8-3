package hashMap_Example;

import java.util.Arrays;
import java.util.StringJoiner;

/*
Написать свой класс MyHashMap как аналог классу HashMap.

Нужно делать с помощью односвязной Node.

Не может хранить две ноды с одинаковых ключами одновременно.

Методы

put(Object key, Object value) добавляет пару ключ + значение
remove(Object key) удаляет пару по ключу
clear() очищает коллекцию
size() возвращает размер коллекции
get(Object key) возвращает значение(Object value) по ключу
 */
public class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private int size;
    private float threshold;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MyHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
        threshold = table.length * DEFAULT_LOAD_FACTOR;
        size = 0;
    }

    //возвращает размер коллекции
    public int size() {
        return size;
    }

    private Node<K, V> getNextNode(Node<K, V> current) {
        return current.getNext();
    }

    //добавляет пару ключ + значение

    public void put(K key, V value) {
        if (key == null) {
            putForNullKey(value);
            return;
        }
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        addNode(key, value, hash, index);
    }

    private void addNode(K key, V value, int hash, int index) {
        Node<K, V> newNode = new Node<>(hash, key, value, null);
        Node<K, V> current = table[index];
        if (current == null) {
            table[index] = newNode;
            size++;
            return;
        } else {
            do {
                if (current.hash == hash && (current.key == key || key.equals(current.key))) {
                    current.value = value;
                    return;
                }
                if (current.getNext() != null) {
                    current = current.getNext();
                } else {
                    break;
                }
            } while (current != null);
            current.setNext(newNode);
            size++;
        }
    }

    private void putForNullKey(V value) {
        addNode(null, value, 0, 0);
    }

    private static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V remove(K key) {
        Node<K, V> removedNode = null;
        Node<K, V> node = null;
        for (int i = 0; i < table.length; i++) {

            if (table[i] != null) {
                if (table[i].key == key) {
                    removedNode = table[i];
                    if (table[i].getNext() == null) {
                        table[i] = null;
                    } else {
                        table[i] = table[i].getNext();
                    }
                    size--;
                    return removedNode.getValue();
                }
                node = table[i].getNext();
            }
            while (node != null) {
                if (node.key == key) {
                    removedNode = node;
                    if (node.getNext() == null) {
                        node = null;
                    } else {
                        node = node.getNext();
                    }
                    size--;
                    return removedNode.getValue();
                }
            }

        }
        return removedNode.getValue();

    }

    public V get(K key) {
        for (Node<K, V> node : table) {
            if (node != null) {
                if (node.key == key) {
                    return node.getValue();
                } else {
                    while (node != null) {
                        node = node.getNext();
                        if (node != null) {
                            if (node.key == key) {
                                return node.getValue();
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //очищает коллекцию
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Node<K, V> node = table[i].getNext();
                if (node != null) {
                    while (node != null) {
                        if (node.getNext() != null) {
                            Node<K, V> next = node.getNext();
                            node.setNext(null);
                            node = next;
                        } else {
                            break;
                        }
                    }
                }
            }
            table[i] = null;
        }
        size = 0;
    }


    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + ", key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public String toString() {
        String begining = "MyHashMap{" +
                "size=" + size + ", nodes: [";
        StringJoiner joiner = new StringJoiner(", ", begining, "]}");
        for (Node<K, V> node : table) {
            if (node == null) {
                //joiner.add("null");
            } else {
                joiner.add(node.toString());
                while (node.getNext() != null) {
                    node = getNextNode(node);
                    joiner.add(node.toString());
                }
            }

        }

        return joiner.toString();
    }

}




package collections;

import java.util.*;

/**
 * Author: 小栗旬
 * Date: 2019/2/14 23:01
 */
public class HashTableDemo<K, V> extends AbstractMap<K, V>
		implements Map<K, V> {


	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}

	static final int hash(Object key) {
		int h;
		return key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
	}

	static class Node<K, V> implements Map.Entry<K, V> {
		final int hash;
		final K key;
		V value;
		HashTableDemo.Node<K, V> next;

		Node(int hash, K key, V value, HashTableDemo.Node<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public final String toString() {
			return key + "=" + value;
		}

		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
				if (Objects.equals(key, e.getKey()) &&
						Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}
	}

	private Node<K, V>[] table;

	final Object getNode(int hash, Object key) {
		Node<K, V>[] tab;
		Node<K, V> first, e;
		K k;
		int n;
		if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
			if (first.hash == hash && ((k=first.key) == key || (k !=null && k.equals(key)))){
				return first;
			}
			if ((e = first.next) !=null){
				do {
					if (e.hash == hash && ((k=e.key) == key || (k !=null && k.equals(key)))){
						return e;
					}
				}while ((e = first.next) !=null);
			}
		}
		return null;

	}


}

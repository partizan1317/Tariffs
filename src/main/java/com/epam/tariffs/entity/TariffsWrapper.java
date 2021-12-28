package com.epam.tariffs.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@XmlRootElement(namespace = "http://www.example.com/tariffs", name = "tariffs")
public class TariffsWrapper {

    @XmlElements({
            @XmlElement(name = "phone-tariff", namespace = "http://www.example.com/tariffs", type = PhoneTariff.class),
            @XmlElement(name = "home-tariff", namespace = "http://www.example.com/tariffs", type = HomeTariff.class)
    })
    private final List<Tariff> tariffs = new ArrayList<>();

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public int size() {
        return tariffs.size();
    }

    public boolean isEmpty() {
        return tariffs.isEmpty();
    }

    public Iterator<Tariff> iterator() {
        return tariffs.iterator();
    }

    public Object[] toArray() {
        return tariffs.toArray();
    }

    public boolean add(Tariff tariff) {
        return tariffs.add(tariff);
    }

    public boolean addAll(Collection<? extends Tariff> collection) {
        return tariffs.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Tariff> collection) {
        return tariffs.addAll(index, collection);
    }

    public void replaceAll(UnaryOperator<Tariff> operator) {
        tariffs.replaceAll(operator);
    }

    public void sort(Comparator<? super Tariff> comparator) {
        tariffs.sort(comparator);
    }

    public void clear() {
        tariffs.clear();
    }

    public Tariff get(int index) {
        return tariffs.get(index);
    }

    public Tariff set(int index, Tariff tariff) {
        return tariffs.set(index, tariff);
    }

    public void add(int index, Tariff element) {
        tariffs.add(index, element);
    }

    public Tariff remove(int index) {
        return tariffs.remove(index);
    }

    public ListIterator<Tariff> listIterator() {
        return tariffs.listIterator();
    }

    public ListIterator<Tariff> listIterator(int index) {
        return tariffs.listIterator(index);
    }

    public List<Tariff> subList(int fromIndex, int toIndex) {
        return tariffs.subList(fromIndex, toIndex);
    }

    public Spliterator<Tariff> spliterator() {
        return tariffs.spliterator();
    }

    public boolean removeIf(Predicate<? super Tariff> filter) {
        return tariffs.removeIf(filter);
    }

    public Stream<Tariff> stream() {
        return tariffs.stream();
    }

    public Stream<Tariff> parallelStream() {
        return tariffs.parallelStream();
    }

    public void forEach(Consumer<? super Tariff> action) {
        tariffs.forEach(action);
    }

}

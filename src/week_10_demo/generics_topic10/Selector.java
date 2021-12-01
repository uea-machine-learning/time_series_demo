package week_10_demo.generics_topic10;

/**
 *
 * @author ajb
 */
public interface Selector<T> {
    boolean select(T o);
}

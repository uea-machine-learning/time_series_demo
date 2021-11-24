package week_9_demo.lambdas;

/**
 *
 * @author ajb
 */
public interface Selector<T> {
    boolean select(T o);
}

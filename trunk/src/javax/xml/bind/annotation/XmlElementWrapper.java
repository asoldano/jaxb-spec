package javax.xml.bind.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Generates a wrapper element around XML representation.
 *
 * This is primarily intended to be used to produce a wrapper
 * XML element around collections. The annotation therefore supports
 * two forms of serialization shown below. 
 *
 * <pre>
 *    //Example: code fragment
 *      int[] names;
 *
 *    // XML Serialization Form 1 (Unwrapped collection)
 *    &lt;names> ... &lt;/names>
 *    &lt;names> ... &lt;/names>
 * 
 *    // XML Serialization Form 2 ( Wrapped collection )
 *    &lt;wrapperElement>
 *       &lt;names> value-of-item &lt;/names>
 *       &lt;names> value-of-item &lt;/names>
 *       ....
 *    &lt;/wrapperElement>
 * </pre>
 *
 * <p> The two serialized XML forms allow a null collection to be
 * represented either by absence or presence of an element with a
 * nillable attribute.
 * 
 * <p> <b>Usage</b> </p>
 * <p>
 * The <tt>@XmlElementWrapper</tt> annotation can be used with the
 * following program elements: 
 * <ul> 
 *   <li> JavaBean property </li>
 *   <li> non static, non transient field </li>
 * </ul>
 *
 * <p>The usage is subject to the following constraints:
 * <ul>
 *   <li> The property must be a collection property </li>
 *   <li> This annotation can be used with the following annotations:
 *            {@link XmlElement}, 
 *            {@link XmlElements},
 *            {@link XmlElementRef},
 *            {@link XmlElementRefs},
 *            {@link javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter}</li>.
 * </ul>
 *
 * <p>See "Package Specification" in javax.xml.bind.package javadoc for
 * additional common information.</p>
 *
 * @author <ul><li>Kohsuke Kawaguchi, Sun Microsystems, Inc.</li><li>Sekhar Vajjhala, Sun Microsystems, Inc.</li></ul>
 * @see XmlElement 
 * @see XmlElements
 * @see XmlElementRef
 * @see XmlElementRefs
 *
 */

@Retention(RUNTIME) @Target({FIELD, METHOD})
public @interface XmlElementWrapper {
    /**
     * Name of the XML wrapper element. By default, the XML wrapper
     * element name is derived from the JavaBean property name.
     */
    String name() default "##default";

    /**
     * XML target namespace of the XML wrapper element.
     * namespace() must be a valid namespace URI. The default XML
     * namespace is the XML namespace of the enclosing class of the
     * Javabean property.
     *
     */
    String namespace() default "##default" ;

    /**
     * If true, the absence of the collection is represented by
     * using <tt>xsi:nil='true'</tt>. Otherwise, it is represented by
     * the absence of the element.
     */
    boolean nillable() default false;
}

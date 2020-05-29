package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *  * 元注解:
 *   * @Target :描述注解能够作用的位置
 *   * @Retention :描述注解被保留的阶段
 *   * @Documented :描述注解是否被抽取到api文档中
 *   * @Inherited :描述注解是否被子类继承
 */
@Target(value = {ElementType.TYPE})//不是只能作用于类上
public @interface 元注解 {

}

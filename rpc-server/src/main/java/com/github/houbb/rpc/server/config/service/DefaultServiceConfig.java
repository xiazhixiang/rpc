package com.github.houbb.rpc.server.config.service;

/**
 * 单个服务配置类
 *
 * 简化用户使用：
 * 在用户使用的时候，这个类应该是不可见的。
 * 直接提供对应的服务注册类即可。
 *
 * 后续拓展
 * （1）版本信息
 * （2）服务端超时时间
 *
 * @author binbin.hou
 * @since 0.0.6
 * @param <T> 实现类泛型
 */
public class DefaultServiceConfig<T> implements ServiceConfig<T> {

    /**
     * 服务的唯一标识
     * @since 0.0.6
     */
    private String id;

    /**
     * 设置引用类
     * @since 0.0.6
     */
    private T reference;

    @Override
    public String id() {
        return id;
    }

    @Override
    public DefaultServiceConfig<T> id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public T reference() {
        return reference;
    }

    @Override
    public DefaultServiceConfig<T> reference(T reference) {
        this.reference = reference;
        return this;
    }
}

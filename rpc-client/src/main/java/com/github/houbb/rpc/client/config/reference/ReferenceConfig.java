package com.github.houbb.rpc.client.config.reference;

import com.github.houbb.rpc.common.config.component.RpcAddress;

import java.util.List;

/**
 * 引用配置类
 *
 * 后期配置：
 * （1）timeout 调用超时时间
 * （2）version 服务版本处理
 * （3）callType 调用方式 oneWay/sync/async
 * （4）check 是否必须要求服务启动。
 *
 * spi:
 * （1）codec 序列化方式
 * （2）netty 网络通讯架构
 * （3）load-balance 负载均衡
 * （4）失败策略 fail-over/fail-fast
 *
 * filter:
 * （1）路由
 * （2）耗时统计 monitor 服务治理
 *
 * 优化思考：
 * （1）对于唯一的 serviceId，其实其 interface 是固定的，是否可以省去？
 * @author binbin.hou
 * @since 0.0.6
 * @param <T> 接口泛型
 */
public interface ReferenceConfig<T> {

    /**
     * 设置服务标识
     * @param serviceId 服务标识
     * @return this
     * @since 0.0.6
     */
    ReferenceConfig<T> serviceId(final String serviceId);

    /**
     * 服务唯一标识
     * @since 0.0.6
     */
    String serviceId();

    /**
     * 服务接口
     * @since 0.0.6
     * @return 接口信息
     */
    Class<T> serviceInterface();

    /**
     * 设置服务接口信息
     * @param serviceInterface 服务接口信息
     * @return this
     * @since 0.0.6
     */
    ReferenceConfig<T> serviceInterface(final Class<T> serviceInterface);

    /**
     * 设置服务地址信息
     * （1）单个写法：ip:port:weight
     * （2）集群写法：ip1:port1:weight1,ip2:port2:weight2
     *
     * 其中 weight 权重可以不写，默认为1.
     *
     * @param addresses 地址列表信息
     * @return this
     * @since 0.0.6
     */
    ReferenceConfig<T> addresses(final String addresses);

    /**
     * 获取对应的引用实现
     * @return 引用代理类
     * @since 0.0.6
     */
    T reference();

    /**
     * 设置超时时间
     * @since 0.0.7
     * @return this
     */
    ReferenceConfig<T> timeout(final long timeoutInMills);

}
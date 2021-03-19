package com.example.demo.lambda.lamadaInterface;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/10/10
 */
@FunctionalInterface
public interface LambdaLoader<T> {

    //数据加载
    public T load();

}

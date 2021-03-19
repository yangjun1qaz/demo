package com.example.demo.BloomFilterDemo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/8 15:24
 * @description：
 * @modified By：
 * @version:
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        //插入的key为字符串，预计数据量为一百万，并且容错率为0.01
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),
                1000000,0.01);
        bloomFilter.put("sunkang");
        System.out.println(bloomFilter.mightContain("sunkang"));
        System.out.println(bloomFilter.mightContain("brayden"));
    }
}

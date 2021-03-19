package com.example.demo.lambda;

import com.example.demo.bean.StudentBean;
import com.example.demo.lambda.lamadaInterface.LambdaLoader;
import org.junit.jupiter.api.Test;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/10/10
 */
public class Lambda2 {

    private StudentBean get(String username, Integer age, LambdaLoader lambdaLoader){
        Object load = lambdaLoader.load();
        return (StudentBean)load;
    }


    @Test
    public void test1(){
        StudentBean studentBean1 = get("brayden", 12, () -> {
            StudentBean studentBean = new StudentBean();
            studentBean.setUsername("sds");
            studentBean.setAge(23);
            return studentBean;

        });
        System.out.println(studentBean1);
    }
}

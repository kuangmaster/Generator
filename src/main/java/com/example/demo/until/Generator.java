package com.example.demo.until;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author kuangmaster
 * @date 2022/3/29--18:55
 */
public class Generator {
    static String ip="" ;               //数据库IP
    static String DataName="";          //数据库名称
    static String username="";          //数据库账号
    static String password="";          //数据库密码

    static String fName="com.my";       //设置父包名
    static String fmName="gcserver";    //设置父包模块名; eg:nuist

    static String[] allTableName= {     //要创建的数据库表名称
            "t_fields_name",

//            "t_user",
//            "t_user",
//            "t_user",
    };


    public static void main(String[] args) {
        String url="jdbc:mysql://"+ip+"/"+DataName+"?useUnicode=true&characterEncoding=UTF-8&ServerTimezone=Asia/Shanghai";
        //指定目录生成
        for (String TableName : allTableName) {
            FastAutoGenerator.create(url, username, password)
                    .globalConfig(builder -> {
                        builder.author("kuangmaster") // 设置作者
                                .fileOverride() // 覆盖已生成文件
                                .outputDir("D:\\test\\"); // 指定输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent(fName) // 设置父包名
                                .moduleName(fmName) // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\test\\com\\my\\gcserver\\")); // 设置mapperXml生成路径
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(TableName) // 设置需要生成的表名
                                .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                    })
                    .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                    .execute();
        }


//         //在当前项目目录生成
//            for (String TableName : allTableName) {
//            FastAutoGenerator.create(url, username, password)
//                    .globalConfig(builder -> {
//                        builder.author("kuangmaster") // 设置作者
//                                .fileOverride() // 覆盖已生成文件
//                                .outputDir(System.getProperty("user.dir")+"/src/main/java/"); // 指定输出目录
//                    })
//                    .packageConfig(builder -> {
//                         builder.parent(fName) // 设置父包名
//                                .moduleName(fmName) // 设置父包模块名
//                                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir")+"/src/main/resources/mapper/")); // 设置mapperXml生成路径
//                    })
//                    .strategyConfig(builder -> {
//                        builder.addInclude(TableName) // 设置需要生成的表名
//                                .addTablePrefix("t_", "c_"); // 设置过滤表前缀
//                    })
//                    .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                    .execute();
//        }



    }
}

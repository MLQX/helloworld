package com.example.demo;

import com.example.demo.esrepo.BlogRepository;
import com.example.demo.pojo.Person;
import com.example.demo.pojo.esentity.Blog;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.util.Iterator;

@SpringBootTest
public class ESTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private BlogRepository blogRepository;
    @Test
    void contextLoads(){
        Person person=new Person("123456","zlc","西湖区",18,"男","hangzhou");
        personService.save(person);
        Person person1=new Person("98712","张三","余杭区",18,"男","hangzhou");
        IndexQuery indexQuery=new IndexQueryBuilder().withObject(person1).build();
        elasticsearchTemplate.index(indexQuery);

    }

    @Test
    void printHello(){
        System.out.println("hello");
    }



    @Test
    void testEsSelect(){
        Iterable<Blog> all = blogRepository.findAll();
        Iterator<Blog> iterator = all.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getContent());
        }
    }
}

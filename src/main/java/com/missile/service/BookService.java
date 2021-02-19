package com.missile.service;

import com.missile.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Missile
 * @Date 2021-02-02-20:14
 */
@Service
public class BookService {
  //  @Qualifier("bookDao")

  //  @Autowired(required = false)
    @Resource
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                 bookDao +
                '}';
    }
}

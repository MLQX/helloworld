package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 *
 * 发布-订阅模式
 */
public class Test38 {


    public static void main(String[] args) {


        GameSubject gameSubject = new GameSubject("如龙","so good!! i like it");

        Observer o1 = new GameObserver();
        gameSubject.addObserver(o1); //添加订阅者

        gameSubject.sendSubject(gameSubject); //通知订阅者





    }
}


//抽象主题类（发布者）
abstract class Subject{
    public List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer o){
        observerList.add(o);
    }


    public void deleteObserver(Observer o ){
        observerList.remove(o);
    }

    public void notisifyObservers(){
        for (Observer o : observerList) {
            o.update(this);
        }
    }
}

/**
 * 游戏具体主题类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
class GameSubject extends Subject{
    private String name;
    private String evaluation;

    public void sendSubject(GameSubject gameSubject) {
        log.debug("GameSubject发生改变，通知所有观察者,and gameSubject evaluation{}",gameSubject.getEvaluation());
        this.notisifyObservers();
    }
}


/**
 * 订阅者
 */
interface Observer{
    void update(Subject subject);
}
class GameObserver implements Observer{

    @Override
    public void update(Subject subject) {


        //订阅发生改变后需要更新的内容
        System.out.println("hello , i changed!");


    }
}
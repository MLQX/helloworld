package com.example.demo.zoo;


import lombok.SneakyThrows;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 分布式注册中心demo
 */
public class ZooTest implements Watcher {

    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        String path = "/helloworld";
        zk = new ZooKeeper("192.168.237.128:2181", 5000, new ZooTest());
        connectedSemaphore.await();
        System.out.println("获取到配置值为： "+new String(zk.getData(path,true,stat)));
        Thread.sleep(Integer.MAX_VALUE);
    }



    @Override
    public void process(WatchedEvent watchedEvent) {
        //zk连接成功
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                connectedSemaphore.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) { //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改,新值为： "+new String(zk.getData(watchedEvent.getPath(),true,stat)));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

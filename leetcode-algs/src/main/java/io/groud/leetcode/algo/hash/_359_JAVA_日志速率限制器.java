package io.groud.leetcode.algo.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/logger-rate-limiter/
 *
 * @author Li.Wei by 2020/3/7
 */
public class _359_JAVA_日志速率限制器 {

    /*
    ["Logger","shouldPrintMessage","shouldPrintMessage"]
    [[],[100,"bug"],[100,"bug"]]
     */
    class Logger {

        private final Map<String, Integer> map = new HashMap<>();

        public Logger() {}

        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer oldTimes = map.get(message);
            if (oldTimes == null) { // 如果日志内容不存在，可以打印并保存打印时间
                map.put(message, timestamp);
                return true;
            }

            // 该日志内容存在情况下
            boolean print = timestamp - oldTimes >= 10;
            if (print)
                map.put(message, timestamp); // 如果打印了，更新最后打印的时间挫，否则被丢弃
            return print;
        }
    }

    /**
     * Your Logger object will be instantiated and called as such: Logger obj = new Logger(); boolean param_1 =
     * obj.shouldPrintMessage(timestamp,message);
     */
}

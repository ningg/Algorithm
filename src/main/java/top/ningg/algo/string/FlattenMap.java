package top.ningg.algo.string;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * 题目： 将 Map 转换为 flatten map.
 *
 * a {
 * b {
 * c
 * }
 * }
 * }
 *
 * 转换为：
 *
 * a.b.c -> value
 *
 * 思路：
 *
 * 1. 输入：Map
 * 2. 返回：Map
 * 3. 回溯：需要知道 key 前缀
 *
 * 进一步疑问：
 *
 * 1. 不使用「递归」，如何实现？
 */
public class FlattenMap {

    /**
     * 将 Map 转换为 flatten map.
     *
     * @param oriMap 原始 Map
     */
    public static Map<String, Object> flattenMap(Map<String, Object> oriMap) {
        // 1. 边界判断
        if (null == oriMap || oriMap.isEmpty()) {
            return null;
        }

        Map<String, Object> flattenMapResult = new HashMap<>();
        flattenMapLoop(null, oriMap, flattenMapResult);
        return flattenMapResult;
    }

    /**
     * 递归进行 Map 打平
     *
     * @param prefix 打平的前缀
     * @param oriMap 原始 Map
     * @param resultMap 最终 Map
     */
    public static void flattenMapLoop(String prefix, Map<String, Object> oriMap, Map<String, Object> resultMap) {
        // 1. 边界判断
        if (null == oriMap || oriMap.isEmpty()) {
            return;
        }

        // 2. 逐个遍历 Map 中元素
        // a. 非 Map 元素，直接拼接前缀后，加入到 resultMap 中，并终止当前元素的递归
        // b. Map 元素，则，更新前缀后，迭代下去
        for (String key : oriMap.keySet()) {
            Object value = oriMap.get(key);

            if (value instanceof Map) {
                Map<String, Object> nextLevelMap = (Map<String, Object>) value;
                String nextLevelPrefix;
                if (StringUtils.isNotBlank(prefix)) {
                    nextLevelPrefix = prefix + "." + key;
                } else {
                    nextLevelPrefix = key;
                }

                // 递归
                flattenMapLoop(nextLevelPrefix, nextLevelMap, resultMap);
            } else {
                String currentKey;
                if (StringUtils.isNotBlank(prefix)) {
                    currentKey = prefix + "." + key;
                } else {
                    currentKey = key;
                }

                // 将打平后的结果，记入 resultMap
                resultMap.put(currentKey, value);
            }
        }
    }


    public static void main(String[] args) {
        Map<String, Object> nextLevelMap = new HashMap<>();
        nextLevelMap.put("a", "abac");
        nextLevelMap.put("b", "abac");

        Map<String, Object> inputMap = new HashMap<>();

        inputMap.put("a", "abac");
        inputMap.put("b", "abac");
        inputMap.put("c", "abac");
        inputMap.put("d", "abac");
        inputMap.put("e", "abac");

        inputMap.put("nextLevel", nextLevelMap);

        Map<String, Object> flattenMap = flattenMap(inputMap);

        System.out.println(JSON.toJSONString(flattenMap));
    }
}

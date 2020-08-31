package io.github.xinshepherd;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 841. 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 *
 * @author Fuxin
 * @since 2020/8/31
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] flags = new boolean[len];
        Deque<Integer> queue = new LinkedList<>();
        for (Integer num : rooms.get(0)) {
            queue.addLast(num);
        }
        flags[0] = true;
        while (!queue.isEmpty()) {
            Integer roomNumKey = queue.poll();
            if (!flags[roomNumKey]) {
                for (Integer num : rooms.get(roomNumKey)) {
                    queue.addLast(num);
                }
                flags[roomNumKey] = true;
            }
        }
        for (boolean flag : flags) {
            if (!flag)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        assertThat(canVisitAllRooms.canVisitAllRooms(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList()
        ))).isTrue();
        assertThat(canVisitAllRooms.canVisitAllRooms(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        ))).isFalse();
    }
}

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2019/3/20.
 */
public class RandomTest {

    /*public static void main(String[] args) {
        // 创造产生随机数的对象
        Random r = new Random();
        // 创建一个存储随机数的集合
        ArrayList<Integer> array = new ArrayList<Integer>();
        // 定义一个统计变量，从0开始
        int count = 0;
        // 判断统计变量是否小于10
        while (count < 10) {
        // 先产生一个随机数
            int number = r.nextInt(20) + 1;
        // 判断该随机数在集合中是否存在
            if (!array.contains(number)) {
        // 如果不存在：就添加，统计变量++
                array.add(number);
                count++;
            }
        }
        // 增强for进行遍历。格式：for（元素数据类型 变量： 数组或者集合）
        for (Integer i : array) {
            System.out.println(i);
        }
    }*/

    public static void main(String[] args) {
        int length = 23;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < 24; i++) {
            if (i % 4 == 1) {
                str.append("<a>").append(String.valueOf(i));
                continue;
            }
            if (i % 4 == 0 || i == length) {
                str.append(String.valueOf(i)).append("</ a>");
                System.out.println(str.toString());
                str = new StringBuilder();
                continue;
            }
            str.append(String.valueOf(i));
        }
    }
}
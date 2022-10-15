import java.util.*;

public class Main {

//    ДЗ 2 Задание 2

    private static final List<String> NAMES = List.of(
          "Иван Иванов",
          "Пётр Петров",
          "Николай Николаев",
          "Алексей Алексеев",
          "Мария Миронова",
          "Мира Касатонова",
          "Фёдор Достоевский",
            "Иван Бунин",
            "Александр Пушкин",
            "Сергей Есенин",
            "Михаил Булгаков"
    );
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();

        add("Владимир Стеблов", queue1, queue2);
        System.out.println();
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);

        remove(queue1, queue2);
        System.out.println();
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);


    //    ДЗ 2 Задание 2
        System.out.println();
        example();

    }

    private static void add(String name,
                            Queue<String> queue1,
                            Queue<String> queue2) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("Нужно позвать Галю!");
            return;
        }

        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    private static void remove(Queue<String> queue1,
                               Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    private static void randomFilling(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }

    private static void example() {
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, (i + j) % 2 == 1 ? "●" : "◯");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
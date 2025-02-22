package algorithm.realExam.iqiyi;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class Iqiyi2021C {


    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10000));

        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        List<Line> lines = Arrays.stream(next.split(",")).map(str -> new StringLine(str))
                .collect(Collectors.toList());
        List<Line> result = s.translateAll(lines, "", threadPoolExecutor);
        String resultString = result.stream().map(l -> l.toString()).collect(Collectors.joining(","));
        System.out.println(resultString);
        reader.close();
        threadPoolExecutor.shutdown();
    }

    public interface Line {
        /**
         * translate the line to the specific language
         * @param language - the language to translate
         * @return the line of translated by the {@code language} */
        Line translate(String language);
    }

    public static class Solution {
        /**
         * translate the all lines to the specific language
         * @param lines the text lines of episode
         * @param language the language to translate
         * @return the lines of translated by the {@code language} */
        public List<Line> translateAll(List<Line> lines, String language, Executor executor) throws InterruptedException {
            Job<Line> job = new Job<>();
            for (Line line : lines) {
                Callable<Line> callable = () -> line.translate(language);
                job.newTask(callable);
            }
            job.execute(executor);
            return job.get();
        }
    }

    public static class Job<V> {

        List<Callable<V>> callables = new LinkedList<>();
        List<Future<V>> futures = new LinkedList<>();

        public void newTask(Callable<V> runnable) {
            //待实现
            callables.add(runnable);
        }


        public void execute(Executor executor) {
            //待实现

            for (int i = 0; i < callables.size(); i++) {
                Future<V> futureTask = ((ThreadPoolExecutor)executor).submit(this.callables.get(i));

                futures.add(futureTask);
            }
        }

        public List<V> get() throws InterruptedException {
            //待实现
            List<V> list = new LinkedList<>();
            for (Future<V> future : futures) {

                try {
                    list.add(future.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }

    }

    /**
     * translate the string line to upper case
     */
    public static class StringLine implements Line {
        private String text;

        public StringLine(String text) {
            this.text = text;
        }

        @Override
        public Line translate(String language) {
            return new StringLine(text.toUpperCase());
        }


        @Override
        public String toString() {
            return text;
        }
    }
}
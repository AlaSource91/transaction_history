public class Task  implements Comparable<Task>
{
    private String taskName;
    private Integer priority;

   // Constructor
    public Task(String taskName, Integer priority)
    {
        this.taskName = taskName;
        this.priority = priority;
    }


    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }
}


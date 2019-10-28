import java.util.List;

public interface StudentInterface {
    /**设计接口定义以下功能
     * 查询所有学生
     * 添加
     * 指定id查找
     * 指定name查找
     * 指定id删除
     * 指定id修改
     */

    /**
     * 查询所有学生
     */
    void showAll();

    /**
     * 添加
     * @return 添加成功返回ture 否则返回false
     */
    boolean addStudent();

    /**
     * 指定id查找
     * @param sid
     * @return 根据id找到的学生对象，如果不存在 返回null
     */
    Student findBySid(int sid);

    /**
     * 指定name查找
     * @param name
     * @return根据name找到的学生列表，如果不存在 返回null
     */
    List<Student>  findByName(String name);

    /**
     * 指定id删除
     * @param sid
     * @return 删除成功 返回true 否则 返回false
     */
    boolean removeBySid(int sid);

    /**
     * 指定id修改
     * @param sid
     * @return 修改成功 返回true 否则 返回false
     */
    boolean modifyBySid(int sid);
}

import java.util.*;

/**
 * 具体实现类
 */
public class StudentSystem implements StudentInterface{
    private Map<Integer,Student> students= new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    //欢迎界面
    public void welcome(){
        System.out.println("*********************************************欢迎来到学生管理系统***********************************************");
    }

    //结束界面
    public void exit(){
        System.out.println();
        System.out.println("*********************************************感谢使用学生管理系统***********************************************");
    }

    //菜单界面
    public void showMenu(){
        System.out.println();
        System.out.println("****************************************************************************************************************");
        System.out.println("1.所有学生信息 2.添加学生信息 3.根据学号查找信息 4.根据姓名查找信息 5.根据学号删除信息 6.根据学号修改信息 0.退出");
        System.out.println("****************************************************************************************************************");
    }

    @Override
    //所有学生信息
    public void showAll() {
        Set<Integer> sids = students.keySet(); //获取map中的键存入set中
        Iterator<Integer> iterator = sids.iterator(); //定义迭代器后续使用遍历
        while(iterator.hasNext()){ //对sids数组进行遍历
            Integer  sid = iterator.next();
            Student student = students.get(sid); //根据键 找到map中的具体值
            System.out.println(student);
        }
    }

    @Override
    //添加学生信息
    public boolean addStudent() {
        int sid = Util.getInputNumber("请输入学生的学号（正整数）：",scanner);
        String name = Util.getInputString("请输入学生的姓名：",scanner);
        int age = Util.getInputNumber("请输入学生的年龄：",scanner);
        Student.Gender gender = Util.getInputString("请输入学生的性别：",scanner).equals("男")? Student.Gender.男: Student.Gender.女;

        Student student = new Student(sid, name,age,gender);
        students.put(sid,student);

        System.out.println("添加成功");
        return true;
    }

    @Override
    //根据学号查找
    public Student findBySid(int sid) {
        Student s = students.get(sid);
        if (s != null){
            System.out.println(s);
        }else {
            System.out.println("该学生不存在");
        }
        return s;
    }

    public Student findBySid() {
        int sid = Util.getInputNumber("请输入需要查找的学生ID",scanner);
        return findBySid(sid);
    }

    @Override
    //根据姓名查找（可能会有重名，有多个对象，采用数组接受）
    public List<Student> findByName(String name) {
        List<Student> list = new ArrayList<>();
        Collection<Student> collection = students.values();
        Iterator<Student> iterator = collection.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(student.getName().equals(name)){
                list.add(student);
            }
        }
        if (list.size() == 0){
            return null;
        } else{
            return list;
        }
    }
    public void findByName(){
        String name = Util.getInputString("请输入需要查找的学生姓名",scanner);
        List<Student> list=findByName(name);
        if(list.size() ==0){
            System.out.println("该学生不存在");
        }else {
            for (int i =0 ; i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }

    @Override
    //根据学号删除
    public boolean removeBySid(int sid) {
        Student student = students.remove(sid);

        return student==null?false:true;
    }
    public void removeBySid(){
        int sid = Util.getInputNumber("请输入需要删除的学生ID",scanner);
        boolean b = removeBySid(sid);
        if (b){
            System.out.println("删除成功");
        }else {
            System.out.println("该学生不存在!");
        }
    }

    @Override
    //根据学号修改
    public boolean modifyBySid(int sid) {
        Student student =students.get(sid);
        if (student != null){
            sid = Util.getInputNumber("请输入修改后学生的学号（正整数）：",scanner);
            String name = Util.getInputString("请输入修改后学生的姓名：",scanner);
            int age = Util.getInputNumber("请输入修改后学生的年龄：",scanner);
            Student.Gender gender = Util.getInputString("请输入修改后学生的性别：",scanner).equals("男")? Student.Gender.男: Student.Gender.女;
            student.setSid(sid);
            student.setName(name);
            student.setAge(age);
            student.setGender(gender);
        }
        return student==null?false:true;
    }
    public void modifyBySid() {
        int sid = Util.getInputNumber("请输入需要修改的学生ID",scanner);
        boolean b = modifyBySid(sid);
        if (b){
            System.out.println("修改成功");

        }else {
            System.out.println("学生不存在");
        }
    }
}

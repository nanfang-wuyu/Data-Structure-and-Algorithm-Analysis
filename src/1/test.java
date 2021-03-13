public class test {
    public static void main(String[] args) {
        User user =new User();
        user.setName("Lucy");
        user.setPassword("123456");
        user.setMoney(1000);
        user.introduce();
        user.expense(2000);
        user.expense(500);
        user.income(1000);
        user.introduce();

    }
}
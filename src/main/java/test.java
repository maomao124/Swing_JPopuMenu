import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Project name(项目名称)：Swing弹出式菜单
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/3
 * Time(创建时间)： 21:40
 * Version(版本): 1.0
 * Description(描述)： 弹出式菜单由 JPopupMenu 类实现，它是一个可弹出并显示一系列选项的小窗口。
 * 它还用于当用户选择菜单项并激活它时显示的“右拉式(pull-right)”菜单，
 * 可以在想让菜单显示的任何其他位置使用。例如，当用户在指定区域中右击时。
 * JPopMenu类的常用方法
 * 方法名称	说明
 * getInvoker()	返回作为此弹出菜单的“调用者”的组件
 * setInvoker(Component invoker)	设置弹出菜单的调用者，即弹出菜单在其中显示的组件
 * addPopupMenuListener(PopupMenuListener1)	添加 PopupMenu 监听器
 * removePopupMenuListener(PopupMenuListener1)	移除 PopupMenu 监听器
 * getPopupMenuListeners()	返回利用 addPopupMenuListener()添加到此 JMenuitem 的所有
 * PopupMenuListener 组成的数组
 * getLabel()	返回弹出菜单的标签
 * setLabel(String label)	设置弹出菜单的标签
 * show(Component invoker,int x,int y)	在调用者的坐标空间中的位置 X、Y 处显示弹出菜单
 * getComponentIndex(Component c)	返回指定组件的索引
 */

public class test extends JFrame
{
    JMenu fileMenu;
    JPopupMenu jPopupMenuOne;
    JMenuItem openFile;
    JMenuItem closeFile;
    JMenuItem exit;
    JRadioButtonMenuItem copyFile;
    JRadioButtonMenuItem pasteFile;
    ButtonGroup buttonGroupOne;
    JLabel label;

    public test()
    {
        jPopupMenuOne = new JPopupMenu();    //创建jPopupMenuOne对象
        buttonGroupOne = new ButtonGroup();
        //创建文件菜单及子菜单，并将子菜单添加到文件菜单中
        fileMenu = new JMenu("文件");
        openFile = new JMenuItem("打开");
        openFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("打开操作");
            }
        });
        closeFile = new JMenuItem("关闭");
        closeFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("关闭操作");
            }
        });
        fileMenu.add(openFile);
        fileMenu.add(closeFile);
        //将fileMenu菜单添加到弹出式菜单中
        jPopupMenuOne.add(fileMenu);
        //添加分割符
        jPopupMenuOne.addSeparator();
        //创建单选菜单项，并添加到ButtonGroup对象中
        copyFile = new JRadioButtonMenuItem("复制");
        copyFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("复制");
            }
        });
        pasteFile = new JRadioButtonMenuItem("粘贴");
        pasteFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("粘贴");
            }
        });
        buttonGroupOne.add(copyFile);
        buttonGroupOne.add(pasteFile);
        //将copyFile添加到jPopupMenuOne中
        jPopupMenuOne.add(copyFile);
        //将pasteFile添加到jPopupMenuOne中
        jPopupMenuOne.add(pasteFile);
        jPopupMenuOne.addSeparator();
        exit = new JMenuItem("退出");
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("关闭程序");
                System.exit(1);
            }
        });
        Font font = new Font("宋体", Font.BOLD, 50);
        label = new JLabel("请右键鼠标");
        label.setFont(font);
        this.add(label, BorderLayout.NORTH);
        //将exit添加到jPopupMenuOne中
        jPopupMenuOne.add(exit);
        //创建监听器对象
        MouseListener popupListener = new PopupListener(jPopupMenuOne);
        //向主窗口注册监听器
        this.addMouseListener(popupListener);
        this.setTitle("弹出式菜单");
        this.setBackground(Color.pink);
        this.setBounds(1920 / 2 - 1280 / 2, 1080 / 2 - 720 / 2, 1280, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //添加内部类，其扩展了MouseAdapter类，用来处理鼠标事件
    static class PopupListener extends MouseAdapter
    {
        JPopupMenu popupMenu;

        PopupListener(JPopupMenu popupMenu)
        {
            this.popupMenu = popupMenu;
        }

        public void mousePressed(MouseEvent e)
        {
            System.out.println("按下鼠标");
            showPopupMenu(e);
        }

        public void mouseReleased(MouseEvent e)
        {
            System.out.println("释放鼠标");
            showPopupMenu(e);
        }

        private void showPopupMenu(MouseEvent e)
        {
            if (e.isPopupTrigger())
            {
                //如果当前事件与鼠标事件相关，则弹出菜单
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    public static void main(String[] args)
    {
        new test();
    }
}

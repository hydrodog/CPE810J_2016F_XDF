package edu.stevens;

import java.awt.*;
import java.awt.event.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MenuTest extends Frame implements ActionListener
{
 //���弸���˵���
 private MenuItem fileNewItem = new MenuItem("New");
 private MenuItem fileopenItem = new MenuItem("OPEN");
 private MenuItem fileExitItem= new MenuItem("EXIT");
 private MenuItem editCopyItem = new MenuItem("COPY");
 private MenuItem editCutItem = new MenuItem("CUT");
 private MenuItem editPasteItem = new MenuItem("PASTE");
 
 //�ڹ��캯�����������ܵĲ��ֹ���
 public MenuTest()
 {
  //���ø���Ĺ��캯�����ǿ�ܵı���ΪMenu Test Program
   super("Menu Test Program");
   //����һ���˵������������˵�����ӵ��˵�����
   Menu fileMenu = new Menu("FILE");
   fileMenu.add(fileNewItem);
   fileMenu.add(fileopenItem);
   fileMenu.add(fileExitItem);
   Menu editMenu = new Menu("EDIT");
   editMenu.add(editCopyItem);
   editMenu.add(editCutItem);
   editMenu.add(editPasteItem);
   MenuBar fileMenuBar =new MenuBar();
   fileMenuBar.add(editMenu);
   fileMenuBar.add(fileMenu);
   //�ڳ�������Ӳ˵���
   setMenuBar(fileMenuBar);
   //ΪExit�˵���ע������¼�
   fileExitItem.addActionListener(this);
   setSize(200, 200);
   //�粻�����������Ի��򲻻���ʾ������deprecated:���޳ɵ�
   show();  
 }

//�����exit��ť���򵯳��Ի���
 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  if(e.getSource()==fileExitItem)
  {
   ConfirmDialog exit = new ConfirmDialog(this, "Confirm exit", "Do you really want to exit?");
   if(exit.isOkay)
   {System.exit(0);} 
  }
 }
 //ÿ��JAVAӦ�ó����ж�Ӧ�ð���main����
 public static void main(String args[])
 {
  //ʵ����MenuTest��
  MenuTest f = new MenuTest();
 }
}
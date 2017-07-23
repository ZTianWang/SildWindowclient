package com.SildWindow;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReceiverGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	ReceiverGUI() {
		TextField sendWinNum,sendTime,resendTime,wrongDate,lostDate;
		Button startSend,stopSend,quit;
		Label nowDate,sildWin,padding;
		JTable dateTable;
		JScrollPane datePane;
		JPanel paraSet,errorSet,nowState,westP,centerP,southP;
		setLayout(new BorderLayout());
		westP = new JPanel();
		westP.setLayout(new GridLayout(2,1));
		paraSet = new JPanel();
		paraSet.setBorder(BorderFactory.createTitledBorder("��������"));
		paraSet.setLayout(new GridLayout(3,2));
		sendWinNum = new TextField("1");
		sendTime = new TextField("1000");
		resendTime = new TextField("2000");
		paraSet.add(new Label("���ܴ��ڣ�"));
		paraSet.add(sendWinNum);
		paraSet.add(new Label("���ն�ʱ����"));
		paraSet.add(sendTime);
		paraSet.add(new Label("��ʱ��ʱ����"));
		paraSet.add(resendTime);
		westP.add(paraSet);
		errorSet = new JPanel();
		errorSet.setSize(200, 400);
		errorSet.setBorder(BorderFactory.createTitledBorder("�������"));
		errorSet.setLayout(new GridLayout(4,1));
		wrongDate = new TextField();
		lostDate = new TextField();
		errorSet.add(new Label("����Ӧ��֡���ո�ָ���:"));
		errorSet.add(wrongDate);
		errorSet.add(new Label("��ʧӦ��֡:"));
		errorSet.add(lostDate);
		westP.add(errorSet);
		add("West",westP);
		centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		nowState = new JPanel();
		nowState.setLayout(new GridLayout(1,4));
		nowState.setBorder(BorderFactory.createTitledBorder("��ǰ״̬"));
		nowDate = new Label();
		sildWin = new Label();
		nowState.add(new Label("��ǰ����֡:"));
		nowState.add(nowDate);
		nowState.add(new Label("���մ���:"));
		nowState.add(sildWin);
		centerP.add("North",nowState);
		dateTable = new JTable();
		dateTable.setPreferredScrollableViewportSize(new Dimension(400,400));
		dateTable.setIntercellSpacing(new Dimension(1,1));
		dateTable.setAutoCreateRowSorter(true);
		datePane = new JScrollPane();
		datePane.add(dateTable);
		centerP.add("Center",datePane);
		add("Center",centerP);
		southP = new JPanel();
		southP.setLayout(new GridLayout(1,4));
		startSend = new Button("��ʼ����");
		stopSend = new Button("ֹͣ����");
		quit = new Button("�˳�");
		padding = new Label();
		padding.setSize(1,200);
		southP.add(padding);
		southP.add(startSend);
		southP.add(stopSend);
		southP.add(quit);
		add("South",southP);
		this.setTitle("Receiver");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ReceiverGUI();
	}
}

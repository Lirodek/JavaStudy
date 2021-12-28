package org.Lirodek.controller;

import org.Lirodek.control.NoticeController;
import org.Lirodek.model.NoticeVo;
import org.Lirodek.view.NoticeAllout;
import org.Lirodek.view.NoticeDelete;
import org.Lirodek.view.NoticeInsert;
import org.Lirodek.view.NoticeMenu;
import org.Lirodek.view.NoticeOneout;
import org.Lirodek.view.NoticeUpdate;
import org.Lirodek.view.NoticeView;

public class R {
	
	public static NoticeVo nVo = new NoticeVo();
	public static NoticeVo arr[];
	
	public static int no=0;
	public  static int choice =0;

	public static final NoticeView menuView = new NoticeMenu();
	public static final NoticeView view = new NoticeView();
	public static final NoticeView allView = new NoticeAllout();
	public static final NoticeView deleteView = new NoticeDelete();
	public static final NoticeView insertView = new NoticeInsert();
	public static final NoticeView noeoutView = new NoticeOneout();
	public static final NoticeView updateView = new NoticeUpdate();
	
	public static final NoticeController controlView = new NoticeController(); 
}

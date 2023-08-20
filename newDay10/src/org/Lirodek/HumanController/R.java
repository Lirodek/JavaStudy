package org.Lirodek.HumanController;

import org.Lirodek.HumanModel.HumanVo;
import org.Lirodek.HumanView.HumanDelete;
import org.Lirodek.HumanView.HumanDetail;
import org.Lirodek.HumanView.HumanEditView;
import org.Lirodek.HumanView.HumanInsetView;
import org.Lirodek.HumanView.HumanListView;
import org.Lirodek.HumanView.HumanMenuView;
import org.Lirodek.HumanView.HumanView;

import HumanControl.HumanControl;

public class R {
	public static int choice;
	public static HumanVo humanVo;
	public static HumanVo[] humanArr;
	
	public static final int SEARCH=0,DETAIL=1;
	public static int type=0;
	
	public static final HumanView menuView = new HumanMenuView();
	
	public static final HumanView insertView = new HumanInsetView();
	public static final HumanView humanDelete = new HumanDelete();
	public static final HumanView humanEdit = new HumanEditView();
	public static final HumanView humanDetail = new HumanDetail();
	public static final HumanView humanListView = new HumanListView();
	
	public static final HumanControl humanController = new HumanControl();
}

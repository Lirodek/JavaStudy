package org.LiroSelf.Controller;

import java.util.ArrayList;

import org.LiroSelf.Model.DataMake;

public class AllController implements Controller {

	@Override
	public void service() {

		ArrayList<DataMake> list = dao.selectAll();
		dataVector.clear();
		for (DataMake dto : list) {
			dataVector.add(dto.getVector());
		}
		tableModel.setDataVector(dataVector, cloumnIndentifiers);

	}

}

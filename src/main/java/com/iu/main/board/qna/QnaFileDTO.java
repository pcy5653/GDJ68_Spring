package com.iu.main.board.qna;

import java.util.List;

import com.iu.main.file.FileDTO;

public class QnaFileDTO extends FileDTO {
	private Long num;
	private List<QnaFileDTO> fileDTOs;
	

	public List<QnaFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<QnaFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}



	

}

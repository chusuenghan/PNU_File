package my.trade.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import my.trade.service.TradeService;
import my.trade.vo.TradeVO;


@Controller
public class TradeController {
	
	@Autowired
	TradeService tradeService;
	
	@RequestMapping(value="/tradeInsertPage.do")
	public String tradeInsertPage() {
		return "trade/tradeInsert.jsp";
	}
	
	@RequestMapping(value="/tradeListPage.do")
	public ModelAndView tradeListPage() {
		ModelAndView mav = new ModelAndView("trade/tradeList.jsp");
		
		List<TradeVO> tradeList = tradeService.selectTradeList();
		
		mav.addObject("tradeList", tradeList);
		
		return mav;
	}
	
	@RequestMapping(value="/tradeInsert.do", method = RequestMethod.POST)
	public String tradeInsert(@ModelAttribute TradeVO trade) throws IOException {
		// 파일 업로드 처리
		String image=null;
		MultipartFile uploadImage = trade.getUploadImage();
		if (!uploadImage.isEmpty()) {
			String originalFileName = uploadImage.getOriginalFilename();
			UUID uuid = UUID.randomUUID();	
			image=uuid+"_"+originalFileName;	
			
			uploadImage.transferTo(new File("E:\\uploads\\" + image));
		}
		trade.setImage(image);
		
		tradeService.insertTrade(trade);
		return "redirect:/tradeListPage.do";
	}
}

package com.knx.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gdata.util.common.base.StringUtil;
import com.knx.pojo.About;
import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;
import com.knx.pojo.Category;
import com.knx.pojo.Index;
import com.knx.pojo.News;
import com.knx.pojo.ProductDetail;
import com.knx.pojo.ProductDownload;
import com.knx.pojo.Training;
import com.knx.pojo.User;
import com.knx.service.about.IAboutService;
import com.knx.service.brand.IBrandService;
import com.knx.service.brandcategorycombination.IBrandCategoryCombinationService;
import com.knx.service.category.ICategoryService;
import com.knx.service.index.IIndexService;
import com.knx.service.news.INewsService;
import com.knx.service.product.IProductService;
import com.knx.service.training.ITrainingService;
import com.knx.service.user.IUserService;
import com.knx.web.dto.BrandDTO;
import com.knx.web.dto.BrandDetailDTO;
import com.knx.web.dto.CategoryDTO;
import com.knx.web.dto.IndexDTO;
import com.knx.web.dto.NewsDTO;
import com.knx.web.dto.ProductDTO;
import com.knx.web.dto.ProductDetailDTO;
import com.knx.web.dto.ProductDownloadDTO;
import com.knx.web.dto.TrainingDTO;
import com.knx.web.dto.UserDTO;
import com.knx.web.util.CategoryUtil;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.PageUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/admin.do")
public class AdminController {

	@Resource(name = "indexService")
	private IIndexService indexService;

	@Resource(name = "newsService")
	private INewsService newsService;

	@Resource(name = "trainingService")
	private ITrainingService trainingService;

	@Resource(name = "userService")
	private IUserService userService;

	@Resource(name = "brandService")
	private IBrandService brandService;

	@Resource(name = "productService")
	private IProductService productService;

	@Resource(name = "categoryService")
	private ICategoryService categoryService;

	@Resource(name = "aboutService")
	private IAboutService aboutService;

	@Resource(name = "brandCategoryCombinationService")
	private IBrandCategoryCombinationService brandCategoryCombinationService;

	@RequestMapping(params = "action=home")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
		String fromurl = ParamUtils.getParameter(request, "fromurl");
		if (fromurl != null) {
			return "redirect:" + fromurl;
		}
		return "admin/home";
	}

	@RequestMapping(params = "action=manageIndex")
	public String manageIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Index> r1c1IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R1C1);
		List<IndexDTO> r1c1IndexDtoList = new ArrayList<IndexDTO>();
		for (Index index : r1c1IndexList) {
			r1c1IndexDtoList.add(index.toDTO());
		}
		model.addAttribute("r1c1IndexDtoList", r1c1IndexDtoList);

		List<Index> r1c2IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R1C2);
		model.addAttribute("r1c2IndexDto", r1c2IndexList.size() > 0 ? r1c2IndexList.get(0).toDTO() : null);

		List<Index> r1c3IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R1C3);
		model.addAttribute("r1c3IndexDto", r1c3IndexList.size() > 0 ? r1c3IndexList.get(0).toDTO() : null);

		List<Index> r2c1IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R2C1);
		model.addAttribute("r2c1IndexDto", r2c1IndexList.size() > 0 ? r2c1IndexList.get(0).toDTO() : null);

		List<Index> r2c2IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R2C2);
		model.addAttribute("r2c2IndexDto", r2c2IndexList.size() > 0 ? r2c2IndexList.get(0).toDTO() : null);

		List<Index> r2c3IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R2C3);
		model.addAttribute("r2c3IndexDto", r2c3IndexList.size() > 0 ? r2c3IndexList.get(0).toDTO() : null);
		return "admin/index/manageIndex";
	}

	@RequestMapping(params = "action=postIndex")
	public String postIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		String positionIdx = ParamUtils.getParameter(request, "position");
		try {
			if (positionIdx == null) {// TODO
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			model.addAttribute("positionIdx", positionIdx);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "admin/index/postIndex";
	}

	@RequestMapping(params = "action=manageUsers")
	public String manageUsers(HttpServletRequest request, HttpServletResponse response, Model model) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = userService.getUserTotalCount();
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<User> userList = userService.getUserList(pageUtil.getStart(), pageUtil.getEnd());
		List<UserDTO> userDtoList = new ArrayList<UserDTO>();
		for (User user : userList) {
			userDtoList.add(user.toDTO());
		}
		model.addAttribute("userDtoList", userDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("admin.do?action=manageUsers", request));
		return "admin/user/manageUsers";
	}

	@RequestMapping(params = "action=modifyPassword")
	public String modifyPassword(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/user/setPassword";
	}

	@RequestMapping(params = "action=setPassword")
	public String setPassword(HttpServletRequest request, HttpServletResponse response, Model model) {
		String oldPassword = ParamUtils.getParameter(request, "oldPassword");
		String newPassword = ParamUtils.getParameter(request, "newPassword");
		String newPasswordSure = ParamUtils.getParameter(request, "newPasswordSure");

		if (StringUtil.isEmptyOrWhitespace(oldPassword)) {
			model.addAttribute("message", "当前密码不能为空");
			return "admin/user/setPassword";
		}

		if (StringUtil.isEmptyOrWhitespace(newPassword)) {
			model.addAttribute("message", "新密码不能为空");
			return "admin/user/setPassword";
		}

		if (StringUtil.isEmptyOrWhitespace(newPasswordSure) || !newPasswordSure.equals(newPassword)) {
			model.addAttribute("message", "确认密码不一致");
			return "admin/user/setPassword";
		}

		User user = userService.findUserByUsername(WebUtil.getUserId(request));
		if (!oldPassword.equals(user.getPasswordU())) {
			model.addAttribute("message", "当前密码不正确");
			return "admin/user/setPassword";
		}

		user.setPasswordU(newPassword);
		userService.saveOrUpdateUser(user);

		return "redirect:/admin.do?action=manageUsers";
	}

	@RequestMapping(params = "action=manageNews")
	public String manageNews(HttpServletRequest request, HttpServletResponse response, Model model) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = newsService.getNewsTotalCount();
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<News> newsList = newsService.getNewsList(pageUtil.getStart(), pageUtil.getEnd());
		List<NewsDTO> newsDtoList = new ArrayList<NewsDTO>();
		for (News news : newsList) {
			newsDtoList.add(news.toDTO());
		}
		model.addAttribute("newsDtoList", newsDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("admin.do?action=manageNews", request));
		return "admin/news/manageNews";
	}

	@RequestMapping(params = "action=postNews")
	public String postNews(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id != 0) {
			News news = newsService.findNewsById(id);
			if (news != null) {
				model.addAttribute("newsDto", news.toDTO());
			}
		}

		return "admin/news/postNews";
	}

	@RequestMapping(params = "action=manageTraining")
	public String manageTraining(HttpServletRequest request, HttpServletResponse response, Model model) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = trainingService.getTrainingTotalCount();
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<Training> trainingList = trainingService.getTrainingList(pageUtil.getStart(), pageUtil.getEnd());
		List<TrainingDTO> trainingDtoList = new ArrayList<TrainingDTO>();
		for (Training training : trainingList) {
			trainingDtoList.add(training.toDTO());
		}
		model.addAttribute("trainingDtoList", trainingDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("admin.do?action=manageTraining", request));
		return "admin/training/manageTraining";
	}

	@RequestMapping(params = "action=postTraining")
	public String postTraining(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id != 0) {
			Training training = trainingService.findTrainingById(id);
			if (training != null) {
				model.addAttribute("trainingDto", training.toDTO());
			}
		}

		return "admin/training/postTraining";
	}

	@RequestMapping(params = "action=manageContact")
	public String manageContact(HttpServletRequest request, HttpServletResponse response, Model model) {
		About about = aboutService.findAboutByType(About.TYPE_CONTACT);
		if (about != null) {
			model.addAttribute("about", about);
		}
		return "admin/about/manageAbout";
	}

	@RequestMapping(params = "action=manageAbout")
	public String manageAbout(HttpServletRequest request, HttpServletResponse response, Model model) {
		About about = aboutService.findAboutByType(About.TYPE_ABOUT);
		if (about != null) {
			model.addAttribute("about", about);
		}
		return "admin/about/manageAbout";
	}

	@RequestMapping(params = "action=postAbout")
	public String postAbout(HttpServletRequest request, HttpServletResponse response, Model model) {
		String type = ParamUtils.getParameter(request, "type");
		if (type != null) {
			About about = aboutService.findAboutByType(type);
			if (about != null) {
				model.addAttribute("about", about);
			}
		}
		if (About.TYPE_ABOUT.equals(type)) {
			model.addAttribute("type", LocalizationUtil.getClientString("About.about", request));
		}
		if (About.TYPE_CONTACT.equals(type)) {
			model.addAttribute("type", LocalizationUtil.getClientString("About.contact", request));
		}

		return "admin/about/postAbout";
	}

	@RequestMapping(params = "action=manageBrand")
	public String manageBrand(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<BrandDetailDTO> brandDetailDTOList = brandService.getBrandDetailDTOList(0, Integer.MAX_VALUE);
		model.addAttribute("brandDetailDTOList", brandDetailDTOList);
		return "admin/brand/manageBrand";
	}

	@RequestMapping(params = "action=postBrand")
	public String postBrand(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id != 0) {
			Brand brand = brandService.findBrandById(id);
			if (brand != null) {
				model.addAttribute("brandDTO", brand.toDTO());
			}

			BrandDetail brandDetail = brandService.findBrandDetailByBrand(brand);
			if (brandDetail != null) {
				model.addAttribute("brandDetailDTO", brandDetail.toDTO());
			}

		}

		return "admin/brand/postBrand";
	}

	@RequestMapping(params = "action=manageBrandCategoryCombination")
	public String manageBrandCategoryCombination(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		try {
			if (brandId == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");

			}
			Brand brand = brandService.findBrandById(brandId);
			if (brand == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			model.addAttribute("brandDTO", brand.toDTO());
			//已有分类
			List<CategoryDTO> dtoList = brandCategoryCombinationService.getCategoryListByBrandId(brandId);
			model.addAttribute("categoryDTOList", dtoList);
			//所有分类，设置未选分类
			List<CategoryDTO> allCategoryDTOList = CategoryUtil.getCategoryTree();
			for(CategoryDTO dto: allCategoryDTOList){
				dto.setShow(false);
				for(CategoryDTO showDto: dtoList){
					if(dto.getIdCat()==showDto.getIdCat()){
						dto.setShow(true);
					}
				}
			}
			model.addAttribute("allCategoryDTOList", allCategoryDTOList);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin/brand/manageBrandCategoryCombination";
	}
	
	@RequestMapping(params = "action=manageCategory")
	public String manageCategory(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		model.addAttribute("categoryDTOList", categoryService.getCategoryDTOList());
		return "admin/category/manageCategory";
	}

	@RequestMapping(params = "action=postCategory")
	public String postCategory(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Category category = null;
		if (id != 0) {
			category = categoryService.findCategoryById(id);
			if (category != null) {
				model.addAttribute("categoryDTO", category.toDTO());
			}
		}
		return "admin/category/postCategory";
	}

	@RequestMapping(params = "action=manageProduct")
	public String manageProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		// 分类及产品
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);

		if (brandId != 0) {
			Brand brand = brandService.findBrandById(brandId);
			if (brand != null) {
				model.addAttribute("brandDTO", brand.toDTO());
			}
		}

		if (categoryId != 0) {
			Category category = categoryService.findCategoryById(categoryId);
			if (category != null) {
				model.addAttribute("categoryDTO", category.toDTO());
			}
		}
		List<ProductDTO> productDTOList = null;
		PageUtil pageUtil = null;
		String pageLink = null;

		int totalCount = productService.getProductTotalCountByBrandIdAndCategoryId(brandId, categoryId);
		pageUtil = new PageUtil(totalCount, curPage, pageSize);
		productDTOList = productService.getProductDTOListByBrandIdAndCategoryId(pageUtil.getStart(), pageUtil.getEnd(), brandId, categoryId);
		pageLink = "admin.do?action=manageProduct&brandId="+brandId+"&categoryId="+categoryId;
		model.addAttribute("productDTOList", productDTOList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar(pageLink, request));
		return "admin/product/manageProduct";
	}

	@RequestMapping(params = "action=postProduct")
	public String postProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);

		model.addAttribute("selectedBrandId", brandId);
		model.addAttribute("selectedCategoryId", categoryId);

		ProductDetail productDetail = null;
		if (id != 0) {
			productDetail = productService.findProductDetailByProductId(id);
			if (productDetail != null) {
				ProductDetailDTO productDetailDTO = productDetail.toDTO();
				model.addAttribute("productDetailDTO", productDetailDTO);
				model.addAttribute("selectedBrandId", productDetailDTO.getBrandDTO().getIdBrd());
				model.addAttribute("selectedCategoryId", productDetailDTO.getCategoryDTO().getIdCat());
			}
		}
		List<BrandDTO> brandDTOList = brandService.getBrandDTOListOrderByName();
		List<CategoryDTO> categoryDTOList = categoryService.getCategoryDTOList();
		model.addAttribute("brandDTOList", brandDTOList);
		model.addAttribute("categoryDTOList", categoryDTOList);

		// ProductDownload
		List<ProductDownload> list = productService.getProductDownloadListByProductId(id);
		List<ProductDownloadDTO> pdownloadDTOList = new ArrayList<ProductDownloadDTO>();
		for (ProductDownload pd : list) {
			pdownloadDTOList.add(pd.toDTO());
		}
		model.addAttribute("pdownloadDTOList", pdownloadDTOList);

		return "admin/product/postProduct";
	}
}

package com.example.demo.ctrl;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.common.SortOrderEnum;
import com.example.demo.dto.AdvanceSearchBookInfoRequest;
import com.example.demo.dto.AdvanceSearchBookRequest;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.BookInfoDto;
import com.example.demo.dto.CreateBookInfoRequest;
import com.example.demo.dto.CreateBookRequest;
import com.example.demo.dto.UpdateBookRequest;
import com.example.demo.dto.common.PageResponse;
import com.example.demo.dto.common.PatchRequest;
import com.example.demo.dto.common.SuccessResponse;
import com.example.demo.exception.LBRException;
import com.example.demo.service.BookManageService;
import com.example.demo.service.BookService;
import com.example.demo.util.RequestUtil;
import com.example.demo.util.SearchUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lbm/v1/book")
@Tag(name = "book Management Controller")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookManageService bookManageService;

	@ApiOperation(value = "API thêm sách")
	@PostMapping("/create")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public SuccessResponse<BookDto> create(@RequestBody CreateBookRequest request) throws Exception {
		return RequestUtil.ok(bookManageService.create(request));
	}

	@ApiOperation(value = "API sửa sách")
	@PostMapping("/update")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public SuccessResponse<BookDto> update(@RequestParam("id") String id,
			@Valid @RequestBody PatchRequest<UpdateBookRequest> request) throws Exception {
		return RequestUtil.ok(bookManageService.update(id, request));
	}

	@ApiOperation(value = "API xóa sách")
	@PostMapping("/delete")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public SuccessResponse<String> update(@PathVariable("id") String id) throws Exception {
		return RequestUtil.ok(bookManageService.delete(id));
	}

	@ApiOperation(value = "API tìm sách theo Id")
	@GetMapping("/{id}")
	@ResponseBody
	public SuccessResponse<BookDto> findById(@PathVariable String id) throws LBRException {
		return RequestUtil.ok(bookManageService.findById(id));
	}

	@ApiOperation(value = "API xem tất cả sách")
	@GetMapping("/get-all")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public PageResponse<BookDto> findAll(@PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
			@Positive @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort,
			@RequestParam(required = false) SortOrderEnum order) {
		Pageable pageable = SearchUtil.getPageableFromParam(page, size, sort, order);
		Page<BookDto> pageData = bookManageService.findAll(pageable);
		return RequestUtil.page(pageData);
	}

	@ApiOperation(value = "API tìm kiếm nâng cao sách")
	@GetMapping("/search")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public PageResponse<BookDto> advanceSearch(@Valid @RequestBody AdvanceSearchBookRequest searchRequest,
			@PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
			@Positive @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort,
			@RequestParam(required = false) SortOrderEnum order) {
		Pageable pageable = SearchUtil.getPageableFromParam(page, size, sort, order);
		Page<BookDto> pageData = bookManageService.advanceSearch(searchRequest, pageable);
		return RequestUtil.page(pageData);
	}

	@ApiOperation(value = "API thêm thông tin sách")
	@PostMapping("/info/create")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public SuccessResponse<BookInfoDto> createBookInfo(@RequestBody CreateBookInfoRequest request) throws Exception {
		return RequestUtil.ok(bookService.create(request));
	}

	@ApiOperation(value = "API sửa thông tin sách")
	@PostMapping("/info/update")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public SuccessResponse<BookInfoDto> updateBookInfo(@RequestParam("id") String id,
			@RequestBody PatchRequest<UpdateBookRequest> request) throws Exception {
		return RequestUtil.ok(bookService.update(id, request));
	}

	@ApiOperation(value = "API xóa thông tin sách")
	@PostMapping("/info/delete")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public SuccessResponse<String> updateBookInfo(@PathVariable("id") String id) throws Exception {
		return RequestUtil.ok(bookService.delete(id));
	}

	@ApiOperation(value = "API tìm thể loại sách theo Id")
	@GetMapping("/info/{id}")
	@ResponseBody
	public SuccessResponse<BookInfoDto> findByIdBookInfo(@PathVariable String id) throws LBRException {
		return RequestUtil.ok(bookService.findById(id));
	}

	@ApiOperation(value = "API xem tất cả thể loại sách")
	@GetMapping("/info/get-all")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public PageResponse<BookInfoDto> findAllBookInfo(@PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
				@Positive @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort,
				@RequestParam(required = false) SortOrderEnum order) {
			Pageable pageable = SearchUtil.getPageableFromParam(page, size, sort, order);
			Page<BookInfoDto> pageData = bookService.findAll(pageable);
			return RequestUtil.page(pageData);
		}

	@ApiOperation(value = "API tìm kiếm thể loại sách , nâng cao")
	@PostMapping("/info/search")
	@ResponseBody
//	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
	public PageResponse<BookInfoDto> advanceSearchBookInfo(@Valid @RequestBody AdvanceSearchBookInfoRequest searchRequest,
			@PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
			@Positive @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort,
			@RequestParam(required = false) SortOrderEnum order) {
		Pageable pageable = SearchUtil.getPageableFromParam(page, size, sort, order);
		Page<BookInfoDto> pageData = bookService.advanceSearch(searchRequest, pageable);
		return RequestUtil.page(pageData);
	}

}

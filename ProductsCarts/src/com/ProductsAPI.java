package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Products;
/**
 * Servlet implementation class ProductsAPI
 */
@WebServlet("/ProductsAPI")
public class ProductsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Products ProObj = new Products();
    public ProductsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String output = ProObj.insertItem(
				request.getParameter("name"),
				request.getParameter("category"),
				request.getParameter("Description"),
				request.getParameter("price"),
				request.getParameter("quantity"),
				request.getParameter("status"));
				response.getWriter().write(output);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
			String output = ProObj.updateProduct(
					paras.get("hidItemIDSave").toString(),
					paras.get("name").toString(),
					paras.get("category").toString(),
					paras.get("Description").toString(),
					paras.get("price").toString(),
					paras.get("quantity").toString(),
					paras.get("status").toString());
			
					response.getWriter().write(output);	
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = ProObj.deleteProduct(paras.get("ID").toString());
		response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			
			for (String param : params)
			{
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		}
		catch (Exception e)
		{
		}
		return map;
	}
}

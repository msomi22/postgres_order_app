package com.himansusahoo.FileAPI.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.himansusahoo.FileAPI.FileUtilProperties;
import com.himansusahoo.FileAPI.bean.Response;
import com.himansusahoo.FileAPI.entity.Order;
import com.himansusahoo.FileAPI.repo.OrderRepository;

@ComponentScan
@Service
public class OderService {

	// private static final int NO_OF_LINES = 1;

	@Autowired
	private OrderRepository orderRepo;

	// @Autowired
	private Path uploadPath;

	// FileUtilProperties prop

	/**
	 * 
	 * @param prop
	 */
	public OderService(FileUtilProperties prop) {
		this.uploadPath = Paths.get(prop.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.uploadPath);
		} catch (Exception e) {
			throw new Error("Unable to create upload directory " + this.uploadPath);
		}
	}

	private void processFile(String filePath) {
		File file = new File(filePath);
		if (file.isFile() && file.canRead()) {
			List<Order> orders = new ArrayList<>();
			try {
				// 15
				AtomicInteger ai = new AtomicInteger(0);
				List<String> content = Files.readAllLines(Paths.get(filePath));
				content.forEach(line -> {
					line = line.trim();
					int lineNo = ai.getAndIncrement();
					if (lineNo > 0) {
						String[] parts = line.split("\\,", -1);

						int item8 = 0;
						float item9 = 0;
						float item10 = 0;
						float item11 = 0;
						float item12 = 0;
						float item13 = 0;

						try {
							item8 = Integer.valueOf(parts[8].replaceAll(" ", ""));
						} catch (Exception e) {
						}
						try {
							item9 = Float.valueOf(parts[9].replaceAll(" ", ""));
						} catch (Exception e) {
						}
						try {
							item10 = Float.valueOf(parts[10].replaceAll(" ", ""));
						} catch (Exception e) {
						}
						try {
							item11 = Float.valueOf(parts[11].replaceAll(" ", ""));
						} catch (Exception e) {
						}
						try {
							item12 = Float.valueOf(parts[12].replaceAll(" ", ""));
						} catch (Exception e) {
						}
						try {
							item13 = Float.valueOf(parts[13].replaceAll(" ", ""));
						} catch (Exception e) {
						}

						Order order = new Order(0l, parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
								parts[6], parts[7], item8, item9, item10, item11, item12, item13);

						for (String data : parts) {
							if (data.isEmpty()) {
								order = null;
								System.err.println("Skipping row >>>> " + line);
								break;
							}
						}

						//

						// add to list
						if (null != order) {
							System.out.println("Adding order >>>> " + order);
							orders.add(order);
						}
					} else {
						System.out.println("Skipping header " + line);
					}

				});
				saveOrders(orders);

				/**
				 * private int id; private String region; private String country; private String
				 * itemType; private String salesChannel; private String orderPriority; private
				 * String orderDate; private String orderId; private String shipDate; private
				 * int unitsSold; private float unitPrice; private float unitCost; private float
				 * totalRevenue; private float totalCost; private float totalProfit;
				 */

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Not a file");
		}

	}

	/**
	 * 
	 * @param orders
	 * @return
	 */
	private int saveOrders(List<Order> orders) {
		List<Order> res = orderRepo.saveAll(orders);
		return res.size();
	}

	/**
	 * 
	 * @param file
	 * @param uploadFolder
	 * @param useThread
	 * @return
	 */
	public ResponseEntity<Response> uploadFile(MultipartFile file, String uploadFolder, boolean useThread) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println("Saving file " + fileName + " in " + uploadFolder);
		try {
			if (fileName.contains("..") || fileName.contains(" ")) {
				throw new Error("Invalid path sequence " + fileName);
			}

			Path targetLocation = this.uploadPath.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			String filePath = uploadFolder + File.separator + fileName;
			//
			if (useThread) {
				Thread uploader = new Thread(new Uploader(filePath), "Uploader");
				uploader.start();
			} else {
				processFile(filePath);
			}

			return ResponseEntity.status(HttpStatus.OK).body(new Response(0, "Accepted"));

		} catch (IOException ex) {
			throw new Error("Unable to save file " + fileName + ".", ex);
		}
	}

	class Uploader implements Runnable {
		private String path;

		public Uploader(String path) {
			this.path = path;
		}

		@Override
		public void run() {
			processFile(path);

		}

	}

}

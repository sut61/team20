package team20.se61.sut.wongnai.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team20.se61.sut.wongnai.Entity.ImageReview;
import team20.se61.sut.wongnai.Entity.PricePerHead;
import team20.se61.sut.wongnai.Entity.ProfilesEntity;
import team20.se61.sut.wongnai.Entity.Rating;
import team20.se61.sut.wongnai.Entity.Review;
import team20.se61.sut.wongnai.Entity.Store;
import team20.se61.sut.wongnai.Repository.ImageReviewRepository;
import team20.se61.sut.wongnai.Repository.PricePerHeadRepository;
import team20.se61.sut.wongnai.Repository.ProfilesRepository;
import team20.se61.sut.wongnai.Repository.RatingRepository;
import team20.se61.sut.wongnai.Repository.ReviewRepository;
import team20.se61.sut.wongnai.Repository.StoreRepository;;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/review")
public class ReviewContoller {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ImageReviewRepository imageReviewRepository;
    @Autowired
    private PricePerHeadRepository pricePerHeadRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private StoreRepository storeRepository;

    @GetMapping()
    public List<Review> ReviewList() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Review> ReviewList(@PathVariable Long id)  {
        Optional<Store> store = storeRepository.findById(id);
        return reviewRepository.findByStore(store.get());
    }

    @GetMapping("/imageReview")
    public List<ImageReview> ImageReviewList() {
        return imageReviewRepository.findAll();
    }

    @GetMapping("/pricePerHead")
    public List<PricePerHead> PricePerHeadList() {
        return pricePerHeadRepository.findAll();
    }

    @GetMapping("/rating")
    public List<Rating> RatingList() {
        return ratingRepository.findAll();
    }

    @PostMapping()
    public Optional<Review> AddReview(Review newReview, @RequestBody Map<String, Object> body) {
        Optional<PricePerHead> pricePerHead = pricePerHeadRepository.findById(Long.valueOf(body.get("pricePerHead").toString()));
        Optional<Rating> rating = ratingRepository.findById(Long.valueOf(body.get("rating").toString()));
        ProfilesEntity profiles = profilesRepository.findByEmail(body.get("email").toString());
        Optional<Store> store = storeRepository.findById(Long.valueOf(body.get("store").toString()));

        newReview.setTitle(body.get("title").toString());
        newReview.setDetail(body.get("detail").toString());
        newReview.setPricePerHead(pricePerHead.get());
        newReview.setRating(rating.get());
        newReview.setProfile(profiles);
        newReview.setStore(store.get()); 
        newReview.setTitle(body.get("title").toString());
        newReview.setDetail(body.get("detail").toString());
        Review saveReview =  reviewRepository.save(newReview);

        

        ArrayList<String> images = (ArrayList<String>) body.get("image");
        for (String image : images) {
            ImageReview newImageReview = new ImageReview(image);
            newImageReview.setReviews(saveReview);
            imageReviewRepository.save(newImageReview);
        }
        
        
        return reviewRepository.findById(saveReview.getId());
    }
}
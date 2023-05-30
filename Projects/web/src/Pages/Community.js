import React from 'react';
import Nav from '../Component/Navbar';
import { useLocation } from 'react-router-dom';
function Community(props){
    const location = useLocation();
    const state = location.state.user;
    return(
        <div>
            <Nav profile={props.profile} setProfile={props.setProfile}></Nav> {/*Narbar Component*/}
            <div className='main'>
                    <input type="radio" id="tab-1" name="show" checked/>

                    <div class="tab">
                        <label for="tab-1">Beauty</label>

                    </div>
                    <div class="content">

                    <div class="content-dis">
                        <div className='Beauty'>
                            <p className='Beauty-title'>Is dying your dog’s fur actually that bad?</p>
                            <p className='Beauty-content'>According to three vets, it is medically safe to dye your dog's fur as long as safe products are used, but whether it is ethical is debatable. While some vets argue that it selfishly only benefits the owner, others believe that it is up to the owner to decide since pets are their property. Although some state legislatures consider it illegal, the law is rarely enforced. As an owner, it is essential to use one's best judgment and take cues from the dog before deciding to dye their fur. Traumatizing a dog for aesthetic reasons is never worth it.</p>
                        </div>
                        <div className='Beauty'>
                            <p className='Beauty-title'>Your dog may be begging for a wellness routine</p>
                            <p className='Beauty-content'>The COVID-19 pandemic has been tough for many people, and their dogs have suffered too. Pet stress increased during the pandemic due to changes in daily routines and more time spent at home. This has led to behavioral problems, such as separation anxiety and territorial issues. Brands and experts are responding to the needs of pets by introducing wellness services and products for dogs. Some of these include holistic grooming experiences and exclusive dog social clubs, which are similar to Soho House or The Britely.</p>
                        </div>
                        <div className='Beauty'>
                            <p className='Beauty-title'>Hair of the Dog: The Rise of Luxe Pet Grooming Products</p>
                            <p className='Beauty-content'>The boundaries between man and beast are eroding as pet owners treat their furry companions like family. This is evident in the growing trend of high-end dog grooming products that mimic human beauty products. Former Vogue staffer Jane Wagman co-founded Pride & Groom, a line of coat-specific pooch-pampering products, with the goal of being "Vidal Sassoon for dogs." The brand offers a range of shampoos, conditioners, a waterless cleanser, and even a signature scent. Dog colognes are formulated with only safe essential oils and in small amounts, creating a fur-freshening mist. The rise of human-inspired dog beauty products aligns with our own wellness regimens, promoting all-natural products. This trend is not just about vanity, but rather the proper treatment of a pet's skin and coat has an enormous impact on its well-being. Spending time with furry friends makes us healthier and happier.</p>
                        </div>
                        
                    </div>
                </div>
                </div>
        </div>
    )
}
export default Community;
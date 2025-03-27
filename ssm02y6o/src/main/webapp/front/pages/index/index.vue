<template>
<view class="content">
	<view :style='{"width":"100%","background":"#F9F9F9","height":"100%"}'>
		<swiper :style='{"width":"94%","margin":"20rpx 3%","borderRadius":"20rpx","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"100%","borderRadius":"20rpx","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>


		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"#f7f7f7","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"23%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","boxShadow":"0px 8rpx 20rpx 0px rgba(0,0,0,0.302)","margin":"0px auto","color":"#333","borderRadius":"20rpx","textAlign":"center","background":"#fff","display":"block","width":"100rpx","lineHeight":"100rpx","fontSize":"64rpx","height":"100rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		

		<!-- 商品推荐 -->
		<view class="listBox recommend">
			<view v-if="false && 1 == 1" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"padding":"0 36rpx","margin":"0 0 0 20rpx"}'>
				<view :style='{"borderColor":"#00B578","color":"#000","textAlign":"center","borderWidth":"0 0 10rpx","width":"38%","fontSize":"36rpx","lineHeight":"48rpx","borderStyle":"solid","height":"40rpx"}'>新闻资讯推荐</view>
			</view>
			
			<view v-if="false && 1 == 2" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			
			
			
			<!-- 样式4 -->
			<view class="list-box style4" :style='{"width":"100%","padding":"24rpx","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
				<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0 0 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="xinwenzixunlist.length > 0" @tap="onDetailTap('xinwenzixun',xinwenzixunlist[0].id)" class="box box1" :style='{"padding":"0","margin":"0","overflow":"hidden","borderRadius":"20rpx","width":"48%","position":"relative","height":"500rpx"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title">主题:{{xinwenzixunlist[0].zhuti}}</view>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-if="xinwenzixunlist[0].tupian.substring(0,4)=='http'" :src="xinwenzixunlist[0].tupian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-else :src="xinwenzixunlist[0].tupian?baseUrl+xinwenzixunlist[0].tupian.split(',')[0]:''"></image>
					</view>
					<view class="list-item-body" :style='{"width":"48%","padding":"0","margin":"0","height":"auto"}'>
						<view v-if="xinwenzixunlist.length > 1" @tap="onDetailTap('xinwenzixun',xinwenzixunlist[1].id)" class="box box2" :style='{"padding":"0","margin":"0 0 20rpx","overflow":"hidden","borderRadius":"20rpx","width":"100%","position":"relative","height":"240rpx"}'>
						  <view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title">主题:{{xinwenzixunlist[1].zhuti}}</view>
						  <image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-if="xinwenzixunlist[1].tupian.substring(0,4)=='http'" :src="xinwenzixunlist[1].tupian"></image>
						  <image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-else :src="xinwenzixunlist[1].tupian?baseUrl+xinwenzixunlist[1].tupian.split(',')[0]:''"></image>
                    </view>
                    <view v-if="xinwenzixunlist.length > 2" @tap="onDetailTap('xinwenzixun',xinwenzixunlist[2].id)" class="box box3" :style='{"padding":"0","margin":"0","overflow":"hidden","borderRadius":"20rpx","width":"100%","position":"relative","height":"240rpx"}'>
						  <view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title">主题:{{xinwenzixunlist[2].zhuti}}</view>
						  <image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-if="xinwenzixunlist[2].tupian.substring(0,4)=='http'" :src="xinwenzixunlist[2].tupian"></image>
						  <image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-else :src="xinwenzixunlist[2].tupian?baseUrl+xinwenzixunlist[2].tupian.split(',')[0]:''"></image>
						</view>
					</view>
				</view>
				<view class="list-item" :style='{"width":"64%","padding":"0","margin":"0 2% 20rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="xinwenzixunlist.length > 3" @tap="onDetailTap('xinwenzixun',xinwenzixunlist[3].id)" class="box box4" :style='{"padding":"0","margin":"0","overflow":"hidden","borderRadius":"20rpx","width":"48%","position":"relative","height":"300rpx"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title ">主题:{{xinwenzixunlist[3].zhuti}}</view>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-if="xinwenzixunlist[3].tupian.substring(0,4)=='http'" :src="xinwenzixunlist[3].tupian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-else :src="xinwenzixunlist[3].tupian?baseUrl+xinwenzixunlist[3].tupian.split(',')[0]:''"></image>
					</view>
					<view v-if="xinwenzixunlist.length > 4" @tap="onDetailTap('xinwenzixun',xinwenzixunlist[4].id)" class="box box5" :style='{"padding":"0","margin":"0","overflow":"hidden","borderRadius":"20rpx","width":"48%","position":"relative","height":"300rpx"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title ">主题:{{xinwenzixunlist[4].zhuti}}</view>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-if="xinwenzixunlist[4].tupian.substring(0,4)=='http'" :src="xinwenzixunlist[4].tupian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-else :src="xinwenzixunlist[4].tupian?baseUrl+xinwenzixunlist[4].tupian.split(',')[0]:''"></image>
					</view>
				</view>
				<view v-if="xinwenzixunlist.length > 5" @tap="onDetailTap('xinwenzixun',xinwenzixunlist[5].id)" class="box box6" :style='{"padding":"0","margin":"0","overflow":"hidden","borderRadius":"20rpx","width":"32%","position":"relative","height":"300rpx"}'>
					<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title ">主题:{{xinwenzixunlist[5].zhuti}}</view>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-if="xinwenzixunlist[5].tupian.substring(0,4)=='http'" :src="xinwenzixunlist[5].tupian"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' class="list-item-image" mode="aspectFill" v-else :src="xinwenzixunlist[5].tupian?baseUrl+xinwenzixunlist[5].tupian.split(',')[0]:''"></image>
				</view>
			</view>
			  
			
			
			  
			
			  
			<view v-if="false && 1 == 3" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		

		<!-- 商品列表 -->
																																																<!-- 商品列表 -->
		
		<!-- 系统简介 -->
		<view :style='{"padding":"16rpx","margin":"20rpx 3%","borderRadius":"20rpx","flexWrap":"wrap","background":"#00B578","display":"flex","width":"94%","position":"relative","height":"auto"}'>
		  <view :style='{"width":"100%","margin":"10rpx","lineHeight":"1.5","fontSize":"48rpx","color":"#333","textAlign":"center"}'>{{systemIntroductionDetail.title}}</view>
		  <view :style='{"width":"0","margin":"0 0 20rpx","lineHeight":"1.5","fontSize":"0px","color":"#999","textAlign":"center"}'>{{systemIntroductionDetail.subtitle}}</view>
		  <view :style='{"width":"30%","padding":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
		    <img :style='{"width":"100%","margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"200rpx"}' :src="baseUrl+systemIntroductionDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"0px"}' :src="baseUrl+systemIntroductionDetail.picture2">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"0px"}' :src="baseUrl+systemIntroductionDetail.picture3">
		  </view>
		  <view :style='{"padding":"0","margin":"0 30rpx 20rpx 0","overflow":"hidden","color":"#fff","top":"100rpx","width":"60%","lineHeight":"2","fontSize":"28rpx","position":"absolute","right":"4rpx","height":"200rpx"}' v-html="systemIntroductionDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		</view>
		
		<!-- 新闻资讯 -->
																																		<view class="listBox news">
			<view v-if="false && 1 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"width":"100%","padding":"10rpx 36rpx","margin":"0","justifyContent":"space-between","display":"flex","height":"60rpx"}'>
				<view :style='{"borderColor":"#00B578","color":"#000","textAlign":"center","borderWidth":"0 0 10rpx","width":"30%","fontSize":"36rpx","lineHeight":"36rpx","borderStyle":"solid","height":"40rpx"}'>公告信息</view>
				<text :style='{"color":"#000","fontSize":"32rpx","lineHeight":"48rpx"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						
		  <!-- 样式4 -->
		  		  
		  <!-- 样式5 -->
		  		  <view class="news-box2" :style='{"width":"100%","padding":"24rpx","margin":"0","height":"auto"}'>
			<block v-for="(item,index) in news" :key="index">
			  <view @tap="onNewsDetailTap(item.id)" v-if="index==0" class="list-item" :style='{"padding":"0","margin":"0 0 20rpx","overflow":"hidden","borderRadius":"20rpx","width":"100%","position":"relative","height":"auto"}'>
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
				<view :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,0.5)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title ">{{item.title}}</view>
			  </view>
			  <view @tap="onNewsDetailTap(item.id)" v-if="index>0" class="list-item" :style='{"width":"100%","height":"auto"}'>
				<view :style='{"borderColor":"#ccc","color":"#333","borderWidth":"0 0 2rpx 0","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title ">{{item.title}}</view>
			  </view>
			</block>
		  </view>
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  
		  <!-- 样式9 -->
		  			
			<view v-if="false && 1 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
																		<!-- 新闻资讯 -->
				
		<!-- 关于我们 -->
		<view :style='{"padding":"24rpx","margin":"20rpx 3% ","borderRadius":"40rpx","flexWrap":"wrap","background":"#00B578","display":"flex","width":"94%","height":"auto"}'>
		  <view :style='{"width":"100%","lineHeight":"1.5","fontSize":"48rpx","color":"#333","textAlign":"center"}'>{{aboutUsDetail.title}}</view>
		  <view :style='{"width":"100%","margin":"0 0 20rpx","lineHeight":"1.5","fontSize":"0px","color":"#999","textAlign":"center"}'>{{aboutUsDetail.subtitle}}</view>
		  <view :style='{"width":"100%","padding":"0 10rpx","flexWrap":"wrap","display":"flex","height":"auto"}'>
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"160rpx"}' :src="baseUrl+aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"160rpx"}' :src="baseUrl+aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"160rpx"}' :src="baseUrl+aboutUsDetail.picture3">
		  </view>
		  <view :style='{"padding":"10rpx","margin":"20rpx 0 20rpx 0","color":"rgb(102, 102, 102)","borderRadius":"20rpx","background":"#fffr","width":"100%","lineHeight":"2","fontSize":"28rpx"}' v-html="aboutUsDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		</view>

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				xinwenzixunlist: [],
				news: [],
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
        async onLoad(){
            this.role = uni.getStorageSync("role");
            let table = uni.getStorageSync("nowTable");
            let res = await this.$api.session(table);
            this.user = res.data;
            this.tableName = table;
            let menus = menu.list();
            this.menuList = menus;
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
			// 轮播图
			let swiperList = []
			let res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
            this.getAboutUs();
            this.getSystemIntroduction();
			// 公告信息
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list

			// 推荐信息
			res = await this.$api.recommend('xinwenzixun', {                                              
                page: 1,
                limit: 6
            });
			this.xinwenzixunlist = res.data.list

		},

		methods: {

			//轮播图跳转
			onSwiperTap(e) {

			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>

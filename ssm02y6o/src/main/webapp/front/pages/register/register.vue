<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"24rpx","backgroundSize":"100%","backgroundImage":"url(http://codegen.caihongy.cn/20221011/7a887ac3e68342dbb8849e2477dec4bf.png)","height":"100%"}'>
		<view :style='{"padding":"24rpx","boxShadow":"0px 8rpx 20rpx 0px rgba(0,0,0,0.302)","margin":"5% 3% ","background":"#fff","display":"block","width":"94%","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"80rpx","display":"block","height":"160rpx"}' src="http://codegen.caihongy.cn/20221010/1d43618a378b4fe8af08897618701465.webp" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.yonghuzhanghao"  type="text"  class="uni-input" name="" placeholder="用户账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.yonghuxingming"  type="text"  class="uni-input" name="" placeholder="用户姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#000","borderStyle":"solid","borderWidth":"0 0 2rpx","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='shangjia'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shangjiazhanghao"  type="text"  class="uni-input" name="" placeholder="商家账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='shangjia'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='shangjia'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='shangjia'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shangjiamingcheng"  type="text"  class="uni-input" name="" placeholder="商家名称" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='shangjia'" @tap="shangjiafengmianTap" class="">
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="ruleForm.fengmian" class="avator" :src="baseUrl+ruleForm.fengmian" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"width":"100%","margin":"0 0 24rpx 0","borderColor":"#000","borderStyle":"solid","borderWidth":"0 0 2rpx","height":"auto"}' v-if="tableName=='shangjia'"  @change="shangjiayingyexukeChange" :value="shangjiayingyexukeIndex" :range="shangjiayingyexukeOptions">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000"}' class="uni-input">{{ruleForm.yingyexuke?ruleForm.yingyexuke:"请选择营业许可"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='shangjia'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","background":"#CCFFFF","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#00B578","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
		</view>
	</view>
</view>
</template>

<script>
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
                shangjiayingyexukeOptions: [],
                shangjiayingyexukeIndex: 0,
				ruleForm: {
				},
				emailcode: "",
				tableName:""
			}
		},
        computed: {
            baseUrl() {
                return this.$base.url;
            }
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='shangjia'){
                this.shangjiayingyexukeOptions = "有许可证,无许可证".split(',');
				this.ruleForm.yingyexuke=this.shangjiayingyexukeOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            shangjiafengmianTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.fengmian = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            shangjiayingyexukeChange(e) {
                    this.shangjiayingyexukeIndex = e.target.value
                    this.ruleForm.yingyexuke = this.shangjiayingyexukeOptions[this.shangjiayingyexukeIndex]
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$utils.msg(`用户姓名不能为空`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
					this.$utils.msg(`年龄应输入整数`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
                if(`shangjia` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`shangjia` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`shangjia` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm, this.emailcode);
				this.$utils.msgBack('注册成功');;
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

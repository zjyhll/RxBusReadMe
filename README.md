###对RxBus一点认识

#### 2016/07/27 （因为自己项目中用到了这个库，但最开始我很难明白它的用法，后来使用中简单总结了下）
 * 这个工程提供了两种方式来调用rxbus
 * 1.发送数据：BusProvider.getInstance().post(Object)            
 * 2.发送数据：使用注释的方式 @Produce （我个人觉得该方法目前没有方法1灵活）                   
 * 3.接收数据@Subscribe                                       
 * 4.传递方与接收方的参数类型必须一致才能发收正常
 * 5.应用场景 ：从某接口、硬件、更复杂的数据来源获取到最新值之后更有效的更新相应的控件或其他

[AndroidKnife/RxBus](https://github.com/AndroidKnife/RxBus)

 
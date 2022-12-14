# SuperTextView
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```
implementation 'com.github.hong-yong:SuperTextView:1.0.3'
```
集成本项目可添加依赖库 implementation 'com.github.hong-yong:SuperTextView:1.0.3'

解决项目中频繁创建shape xml资源文件，造成drawable下大量xml资源堆积得不到很好的复用，文件命名各式各样，不好查早到是否有你要的shape资源
本框架支持常见的组件库TextView,EditText,FrameLayout,LinearLayout,ConstraintLayout,RelativeLayout对应的封装组件如下：SuperTextView，SuperEditText，
SuperFrameLayout，SuperLinearLayout，SuperConstraintLayout,SuperRelativeLayout。

SuperTextView支持常见的shape定义，还支持按压变色，按压渐变变色用法如下

//我是TextView按压变色
```
 <com.shape.library.SuperTextView
        android:id="@+id/tv_1"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        app:radius="12dp"
        app:solidColor="#4880ff"
        app:isTouch="true"
        app:solidTouchColor="#ffccdd"
        android:textColor="#ffffff"
        android:text="我是TextView按压变色"
        />
```
 //我是TextView按压渐变
```
    <com.shape.library.SuperTextView
        android:id="@+id/tv_2"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        app:startColor="#ffFF0000"
        app:endColor="#ffAECFFF"
        app:startTouchColor="#ffCC80ff"
        app:endTouchColor="#ff71aaff"
        app:radius="8dp"
        app:isTouch="true"
        android:text="我是TextView按压渐变"
        android:textColor="#ffffff"
        />
```
//我是TextView设置setEnabled变色
```
  <com.shape.library.SuperTextView
        android:id="@+id/tv_3"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        app:solidColor="#FF0000"
        app:solidTouchColor="#0000FF"
        app:radius="8dp"
        app:isTouch="false"
        android:text="我是TextView设置setEnabled变色"
        android:textColor="#ffffff"
        />
```
//我是EditText
```
 <com.shape.library.SuperEditText
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:radius="20dp"
        android:gravity="center"
        app:solidColor="#ffffff"
        app:strokeColor="@color/black"
        app:strokeWith="1dp"
        android:hint="我是EditText请输入文字"
        />
   ```
   //我是ConstraintLayout
   ```
<com.shape.library.SuperConstraintLayout
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:radius="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        app:gradientMode="leftToRight"
        app:startColor="#FF0000"
        app:endColor="#0000FF"
        >
       
    </com.shape.library.SuperConstraintLayout>
   ```
   

# SuperTextView

集成本项目可添加依赖库 implementation 'com.github.hong-yong:SuperTextView:V1.0.2'

解决项目中频繁创建shape xml资源文件，造成drawable下大量xml资源堆积得不到很好的复用，文件命名各式各样，不好查早到是否有你要的shape资源
本框架支持常见的组件库TextView,EditText,FrameLayout,LinearLayout,ConstraintLayout对应的封装组件如下：SuperTextView，SuperEditText，
SuperFrameLayout，SuperLinearLayout，SuperConstraintLayout。

SuperTextView支持常见的shape定义，还支持按压变色，按压渐变变色用法如下
 //按压效果变色
 <com.shape.library.SuperTextView
        android:id="@+id/tv_1"
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        app:radius="12dp"
        app:solidColor="#4880ff"
        app:isTouch="true"
        app:solidTouchColor="#ffccdd"
        android:text="我是TextView"
        />
        //LinearLayout
        <com.shape.library.SuperLinearLayout
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:radius="20dp"
        app:gradientMode="leftToRight"
        app:startColor="#FF0000"
        app:endColor="#0000FF"
        android:gravity="center"
        app:strokeWith="1dp"
        app:strokeColor="@color/black"
        >
      
    </com.shape.library.SuperLinearLayout>

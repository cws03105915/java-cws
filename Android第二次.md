##利用SimpleAdapter实现如下界面效果
（1）注意列表项的布局（2）图片使用QQ群附件资源（3）使用Toast显示选中的列表项信息
<pre><code>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="75dp"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:layout_gravity="center_vertical"
            android:layout_weight="1"
            android:textSize="20sp" />

        <ImageView
            android:id="@+id/img"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center_vertical"
            android:layout_margin="20dp"/>
    </LinearLayout>
</LinearLayout>

</pre></code>


atx-style:
##创建如图所示的自定义对话框请创建一个如图所示的布局，
调用 AlertDialog.Builder 对象上的 setView() 将布局添加到 AlertDialog。
<pre><code>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/dialog">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxLength="20"
        android:hint="Username"
        android:id="@+id/username">
    </EditText>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxLength="20"
        android:hint="Password"
        android:inputType="textPassword"
        android:id="@+id/password">
    </EditText>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <Button
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Cancel"/>
        <Button
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Sign in"/>

    </LinearLayout>
</LinearLayout>

</pre></code>




atx-style:
##使用XML定义菜单字体大小（有小，中，大这3个选项；分别对应10号字，16号字和20号字）；
点击之后设置测试文本的字体普通菜单项，点击之后弹出Toast提示字体颜色
（有红色和黑色这2个选项），点击之后设置测试文本的字体
<pre><code>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    tools:context=".xml_test2_3">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            android:theme="@style/AppTheme.AppBarOverlay"
            app:title="test2_3"
            app:popupTheme="@style/AppTheme.PopupOverlay"/>

        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="用于测试的内容" />
    </LinearLayout>
</LinearLayout>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="点击弹窗"
        android:layout_gravity="center"
        android:id="@+id/bt1"/>
</LinearLayout>

</pre></code>



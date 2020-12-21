<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <div id="content-wrapper" class="d-flex flex-column">
 <div id="content">
  <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar static-top shadow" style="margin: 0px;">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-info d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="請搜尋" aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-info" type="button">
                 <i class="fa fa-search" aria-hidden="true"></i>
                </button>
              </div>
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">
            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="請搜尋" aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            <div id="app">
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown " role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                <i class="fa fa-bell" aria-hidden="true" ></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">{{unReadSum}}</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown" >
                <h6 class="dropdown-header">
                  	通知中心
                </h6>
                <div>
                  <div >
                <a v-for="item in list" class="dropdown-item d-flex align-items-center" :href="item.link">
                  <div class="mr-3">
                    <div :class="item.type">
                      <i :class="item.icon"></i>
                    </div>
                  </div>
                    <div class="small text-gray-500">{{item.time}}</div>
                    <span v-if="item.status===1" class="font-weight-bold">{{item.contentAC}}</span>
                    <span v-else class="small text-gray-500">{{item.contentAC}}</span>
                </a>
                <a  class="dropdown-item text-center small text-gray-500" href="#">瀏覽所有通知</a>
                </div>
                  </div>
               
              </div>
            </li>
		</div>
            <!-- Nav Item - Messages -->
<!--             <li class="nav-item dropdown no-arrow mx-1"> -->
<!--               <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!--                 <i class="fa fa-envelope" aria-hidden="true"></i> -->
<!--                 Counter - Messages -->
<!--                 <span class="badge badge-danger badge-counter">7</span> -->
<!--               </a> -->
<!--               Dropdown - Messages -->
<!--               <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown"> -->
<!--                 <h6 class="dropdown-header"> -->
<!--                   Message Center -->
<!--                 </h6> -->
<!--                 <a class="dropdown-item d-flex align-items-center" href="#"> -->
<!--                   <div class="dropdown-list-image mr-3"> -->
<!--                     <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt=""> -->
<!--                     <div class="status-indicator bg-success"></div> -->
<!--                   </div> -->
<!--                   <div class="font-weight-bold"> -->
<!--                     <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div> -->
<!--                     <div class="small text-gray-500">Emily Fowler Â· 58m</div> -->
<!--                   </div> -->
<!--                 </a> -->
<!--                 <a class="dropdown-item d-flex align-items-center" href="#"> -->
<!--                   <div class="dropdown-list-image mr-3"> -->
<!--                     <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt=""> -->
<!--                     <div class="status-indicator"></div> -->
<!--                   </div> -->
<!--                   <div> -->
<!--                     <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div> -->
<!--                     <div class="small text-gray-500">Jae Chun Â· 1d</div> -->
<!--                   </div> -->
<!--                 </a> -->
<!--                 <a class="dropdown-item d-flex align-items-center" href="#"> -->
<!--                   <div class="dropdown-list-image mr-3"> -->
<!--                     <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt=""> -->
<!--                     <div class="status-indicator bg-warning"></div> -->
<!--                   </div> -->
<!--                   <div> -->
<!--                     <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div> -->
<!--                     <div class="small text-gray-500">Morgan Alvarez Â· 2d</div> -->
<!--                   </div> -->
<!--                 </a> -->
<!--                 <a class="dropdown-item d-flex align-items-center" href="#"> -->
<!--                   <div class="dropdown-list-image mr-3"> -->
<!--                     <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt=""> -->
<!--                     <div class="status-indicator bg-success"></div> -->
<!--                   </div> -->
<!--                   <div> -->
<!--                     <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div> -->
<!--                     <div class="small text-gray-500">Chicken the Dog Â· 2w</div> -->
<!--                   </div> -->
<!--                 </a> -->
<!--                 <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a> -->
<!--               </div> -->
<!--             </li> -->

<!--             <div class="topbar-divider d-none d-sm-block"></div> -->

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">管理員</span>
                <img class="img-profile rounded-circle" src="data:image/jpg;base64, ${sessionScope.memberPic}">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <script>
        var vm2 = new Vue({
        	el:'#app',
        	data() {
        		return {
            		
					list:null,
					text:null,
					unReadSum:null
        		}
	    	},
	    	created: function(){
      	          var self = this;
//       	          var apid = $("#productID").val();
      	          $.ajax({
      	              type:"get",
      	              url:"/Art/14/showAltartCenter.ctrl",    
      	              contentType: "application/json",
      	              dataType:"json",
      	              success:function(value){
      	              	self.list = value;
      	              UnReadSum()
      	              	
      	              },
      	              error:function(){
      	                  alert("整組壞光光");
      	              }
      	          });

      	        
      	      }
        	})
        </script>

        <!-- End of Topbar -->
  <script>
  $(document).ready(function () {
      var self = vm;
    $.ajax({
      type:"get",
      url:"/Art/14/sum.ctrl",    
//       contentType: "application/json",
      dataType:"text",
      success:function(value){
      	self.text = value;
      	
      },
      error:function(){
          alert("整組壞光光");
      }
    });
  })
  
  
  function UnReadSum() {
        	 var self = vm2;
        	 $.ajax({
	              type:"get",
	              url:"/Art/14/UnReadSum",    
	              dataType:"text",
	              success:function(sum){
	              	self.unReadSum = sum;
	              	
	              },
	              error:function(){
	                  alert("UnReadSum():整組壞光光");
	              }
	          });
         }
  </script>
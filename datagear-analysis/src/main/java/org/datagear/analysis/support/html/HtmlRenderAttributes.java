/*
 * Copyright (c) 2018 datagear.tech. All Rights Reserved.
 */

/**
 * 
 */
package org.datagear.analysis.support.html;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import org.datagear.analysis.Chart;
import org.datagear.analysis.ChartTheme;
import org.datagear.analysis.RenderContext;
import org.datagear.analysis.RenderStyle;
import org.datagear.util.Global;
import org.datagear.util.StringUtil;

/**
 * HTML渲染属性常量。
 * 
 * @author datagear@163.com
 *
 */
public class HtmlRenderAttributes
{
	public static final String RENDER_STYPE = "renderStyle";

	public static final String CHART_THEME = "chartTheme";

	public static final String LOCALE = "locale";

	public static final String CHART_ELEMENT_ID = "chartElementId";

	public static final String CHART_NOT_RENDER_ELEMENT = "chartNotRenderElement";

	public static final String CHART_VAR_NAME = "chartVarName";

	public static final String CHART_RENDER_CONTEXT_VAR_NAME = "chartRenderContextVarName";

	public static final String CHART_NOT_RENDER_SCRIPT_TAG = "chartNotRenderScriptTag";

	public static final String CHART_SCRIPT_NOT_INVOKE_RENDER = "chartScriptNotInvokeRender";

	protected static final AtomicInteger CHART_ELEMENT_ID_SEQUENCE = new AtomicInteger(1);

	protected static final AtomicInteger CHART_VAR_NAME_SEQUENCE = new AtomicInteger(1);

	protected static final AtomicInteger DASHBOARD_VAR_NAME_SEQUENCE = new AtomicInteger(1);

	/**
	 * 获取{@linkplain RenderStyle}，没有则返回{@code null}。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static RenderStyle getRenderStyle(RenderContext renderContext)
	{
		return renderContext.getAttribute(RENDER_STYPE);
	}

	/**
	 * 设置{@linkplain RenderStyle}。
	 * 
	 * @param renderContext
	 * @param renderStyle
	 */
	public static void setRenderStyle(RenderContext renderContext, RenderStyle renderStyle)
	{
		renderContext.setAttribute(RENDER_STYPE, renderStyle);
	}

	/**
	 * 获取{@linkplain ChartTheme}，没有则返回{@code null}。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static ChartTheme getChartTheme(RenderContext renderContext)
	{
		return renderContext.getAttribute(RENDER_STYPE);
	}

	/**
	 * 设置{@linkplain ChartTheme}。
	 * 
	 * @param renderContext
	 * @param chartTheme
	 */
	public static void setChartTheme(RenderContext renderContext, ChartTheme chartTheme)
	{
		renderContext.setAttribute(CHART_THEME, chartTheme);
	}

	/**
	 * 获取{@linkplain Locale}，没有则返回{@code null}。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static Locale getLocale(RenderContext renderContext)
	{
		return renderContext.getAttribute(LOCALE);
	}

	/**
	 * 设置{@linkplain Locale}。
	 * 
	 * @param renderContext
	 * @param locale
	 */
	public static void setLocale(RenderContext renderContext, Locale locale)
	{
		renderContext.setAttribute(LOCALE, locale);
	}

	/**
	 * 获取用于渲染图表的HTML元素ID，没有则返回{@code null}。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static String getChartElementId(RenderContext renderContext)
	{
		return renderContext.getAttribute(CHART_ELEMENT_ID);
	}

	/**
	 * 设置用于渲染图表的HTML元素ID。
	 * 
	 * @param renderContext
	 * @param chartElementId
	 */
	public static void setChartElementId(RenderContext renderContext, String chartElementId)
	{
		renderContext.setAttribute(CHART_ELEMENT_ID, chartElementId);
	}

	/**
	 * 移除图是否不渲染图表HTML元素。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static String removeChartElementId(RenderContext renderContext)
	{
		return renderContext.removeAttribute(CHART_ELEMENT_ID);
	}

	/**
	 * 获取是否不渲染图表HTML元素。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static boolean getChartNotRenderElement(RenderContext renderContext)
	{
		Boolean re = renderContext.getAttribute(CHART_NOT_RENDER_ELEMENT);

		return (re == null ? false : re.booleanValue());
	}

	/**
	 * 设置图是否不渲染图表HTML元素。
	 * <p>
	 * 如果设置为{@code true}，那么必须设置{@linkplain #setChartElementId(RenderContext, String)}。
	 * </p>
	 * 
	 * @param renderContext
	 * @param chartNotRenderElement
	 */
	public static void setChartNotRenderElement(RenderContext renderContext, boolean chartNotRenderElement)
	{
		renderContext.setAttribute(CHART_NOT_RENDER_ELEMENT, chartNotRenderElement);
	}

	/**
	 * 移除图是否不渲染图表HTML元素。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static Boolean removeChartNotRenderElement(RenderContext renderContext)
	{
		return renderContext.removeAttribute(CHART_NOT_RENDER_ELEMENT);
	}

	/**
	 * 获取图表的JS变量名，没有则返回{@code null}。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static String getChartVarName(RenderContext renderContext)
	{
		return renderContext.getAttribute(CHART_VAR_NAME);
	}

	/**
	 * 设置图表的JS变量名。
	 * 
	 * @param renderContext
	 * @param chartVarName
	 */
	public static void setChartVarName(RenderContext renderContext, String chartVarName)
	{
		renderContext.setAttribute(CHART_VAR_NAME, chartVarName);
	}

	/**
	 * 移除图表的JS变量名。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static String removeChartVarName(RenderContext renderContext)
	{
		return renderContext.removeAttribute(CHART_VAR_NAME);
	}

	/**
	 * 获取图表{@linkplain Chart#getRenderContext()}JS变量名，没有则返回{@code null}。
	 * <p>
	 * 如果有返回值，那么{@linkplain HtmlChartPlugin}将不输出{@linkplain Chart#getRenderContext()}内容，而直接赋值为此变量。
	 * </p>
	 * 
	 * @param renderContext
	 * @return
	 */
	public static String getChartRenderContextVarName(RenderContext renderContext)
	{
		return renderContext.getAttribute(CHART_RENDER_CONTEXT_VAR_NAME);
	}

	/**
	 * 设置图表{@linkplain Chart#getRenderContext()}JS变量名。
	 * 
	 * @param renderContext
	 * @param chartVarName
	 */
	public static void setChartRenderContextVarName(RenderContext renderContext, String chartVarName)
	{
		renderContext.setAttribute(CHART_RENDER_CONTEXT_VAR_NAME, chartVarName);
	}

	/**
	 * 移除图表{@linkplain Chart#getRenderContext()}JS变量名。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static String removeChartRenderContextVarName(RenderContext renderContext)
	{
		return renderContext.removeAttribute(CHART_RENDER_CONTEXT_VAR_NAME);
	}

	/**
	 * 获取图表脚本是否不渲染{@code <script>}标签。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static boolean getChartNotRenderScriptTag(RenderContext renderContext)
	{
		Boolean re = renderContext.getAttribute(CHART_NOT_RENDER_SCRIPT_TAG);

		return (re == null ? false : re.booleanValue());
	}

	/**
	 * 设置图表脚本是否不渲染{@code <script>}标签。
	 * 
	 * @param renderContext
	 * @param chartNotRenderScriptTag
	 */
	public static void setChartNotRenderScriptTag(RenderContext renderContext, boolean chartNotRenderScriptTag)
	{
		renderContext.setAttribute(CHART_NOT_RENDER_SCRIPT_TAG, chartNotRenderScriptTag);
	}

	/**
	 * 移除图表脚本是否不渲染{@code <script>}标签属性。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static Boolean removeChartNotRenderScriptTag(RenderContext renderContext)
	{
		return renderContext.removeAttribute(CHART_NOT_RENDER_SCRIPT_TAG);
	}

	/**
	 * 获取图表脚本是否不调用渲染函数。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static boolean getChartScriptNotInvokeRender(RenderContext renderContext)
	{
		Boolean re = renderContext.getAttribute(CHART_SCRIPT_NOT_INVOKE_RENDER);

		return (re == null ? false : re.booleanValue());
	}

	/**
	 * 设置图表脚本是否不调用渲染函数。
	 * 
	 * @param renderContext
	 * @param chartScriptNotInvokeRender
	 */
	public static void setChartScriptNotInvokeRender(RenderContext renderContext, boolean chartScriptNotInvokeRender)
	{
		renderContext.setAttribute(CHART_SCRIPT_NOT_INVOKE_RENDER, chartScriptNotInvokeRender);
	}

	/**
	 * 移除图表脚本是否不调用渲染函数。
	 * 
	 * @param renderContext
	 * @return
	 */
	public static Boolean removeChartScriptNotInvokeRender(RenderContext renderContext)
	{
		return renderContext.removeAttribute(CHART_SCRIPT_NOT_INVOKE_RENDER);
	}

	/**
	 * 生成图表HTML元素ID。
	 * 
	 * @return
	 */
	public static String generateChartElementId()
	{
		return generateChartElementId(CHART_ELEMENT_ID_SEQUENCE.getAndIncrement());
	}

	/**
	 * 生成图表HTML元素ID。
	 * 
	 * @param seq
	 * @return
	 */
	public static String generateChartElementId(int seq)
	{
		return StringUtil.firstLowerCase(Global.PRODUCT_NAME_EN) + "ChartElement_" + seq;
	}

	/**
	 * 生成图表变量名。
	 * 
	 * @return
	 */
	public static String generateChartVarName()
	{
		return generateChartVarName(CHART_VAR_NAME_SEQUENCE.getAndIncrement());
	}

	/**
	 * 生成图表变量名。
	 * 
	 * @param seq
	 * @return
	 */
	public static String generateChartVarName(int seq)
	{
		return StringUtil.firstLowerCase(Global.PRODUCT_NAME_EN) + "Chart_" + seq;
	}

	/**
	 * 生成看板变量名。
	 * 
	 * @return
	 */
	public static String generateDashboardVarName()
	{
		return generateDashboardVarName(DASHBOARD_VAR_NAME_SEQUENCE.getAndIncrement());
	}

	/**
	 * 生成看板变量名。
	 * 
	 * @param seq
	 * @return
	 */
	public static String generateDashboardVarName(int seq)
	{
		return StringUtil.firstLowerCase(Global.PRODUCT_NAME_EN) + "Dashboard_" + seq;
	}

	/**
	 * 重置生成序列。
	 */
	public static void resetGenerateSequence()
	{
		CHART_ELEMENT_ID_SEQUENCE.set(1);
		CHART_VAR_NAME_SEQUENCE.set(1);
		DASHBOARD_VAR_NAME_SEQUENCE.set(1);
	}
}
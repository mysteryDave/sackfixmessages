package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class MarketDataSnapshotFullRefreshMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                                totNumReportsField:Option[TotNumReportsField]=None,
                                                mDReportIDField:Option[MDReportIDField]=None,
                                                clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                                mDBookTypeField:Option[MDBookTypeField]=None,
                                                mDSubBookTypeField:Option[MDSubBookTypeField]=None,
                                                marketDepthField:Option[MarketDepthField]=None,
                                                mDFeedTypeField:Option[MDFeedTypeField]=None,
                                                refreshIndicatorField:Option[RefreshIndicatorField]=None,
                                                tradeDateField:Option[TradeDateField]=None,
                                                mDReqIDField:Option[MDReqIDField]=None,
                                                mDStreamIDField:Option[MDStreamIDField]=None,
                                                instrumentComponent:InstrumentComponent,
                                                undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                                instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                                financialStatusField:Option[FinancialStatusField]=None,
                                                corporateActionField:Option[CorporateActionField]=None,
                                                netChgPrevDayField:Option[NetChgPrevDayField]=None,
                                                mDFullGrpComponent:MDFullGrpComponent,
                                                applQueueDepthField:Option[ApplQueueDepthField]=None,
                                                applQueueResolutionField:Option[ApplQueueResolutionField]=None,
                                                routingGrpComponent:Option[RoutingGrpComponent]=None) extends SfFixMessageBody("W")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    totNumReportsField.foreach(fmt(b,_))
    mDReportIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    mDBookTypeField.foreach(fmt(b,_))
    mDSubBookTypeField.foreach(fmt(b,_))
    marketDepthField.foreach(fmt(b,_))
    mDFeedTypeField.foreach(fmt(b,_))
    refreshIndicatorField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    mDReqIDField.foreach(fmt(b,_))
    mDStreamIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    financialStatusField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    netChgPrevDayField.foreach(fmt(b,_))
    fmt(b,mDFullGrpComponent)
    applQueueDepthField.foreach(fmt(b,_))
    applQueueResolutionField.foreach(fmt(b,_))
    routingGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object MarketDataSnapshotFullRefreshMessage extends SfFixMessageDecoder {
  val MsgType="W"
  val MsgName="MarketDataSnapshotFullRefresh"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || 
    MDFullGrpComponent.isMandatoryField(tagId) || RoutingGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TotNumReportsField.TagId, MDReportIDField.TagId, ClearingBusinessDateField.TagId, MDBookTypeField.TagId, MDSubBookTypeField.TagId, 
    MarketDepthField.TagId, MDFeedTypeField.TagId, RefreshIndicatorField.TagId, TradeDateField.TagId, MDReqIDField.TagId, 
    MDStreamIDField.TagId, FinancialStatusField.TagId, CorporateActionField.TagId, NetChgPrevDayField.TagId, ApplQueueDepthField.TagId, 
    ApplQueueResolutionField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || 
    MDFullGrpComponent.isOptionalField(tagId) || RoutingGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || MDFullGrpComponent.isFieldOf(tagId) || RoutingGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataSnapshotFullRefreshMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(TotNumReportsField.TagId).flatMap(f=>TotNumReportsField.decode(f)),
        myFields.get(MDReportIDField.TagId).flatMap(f=>MDReportIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(MDBookTypeField.TagId).flatMap(f=>MDBookTypeField.decode(f)),
        myFields.get(MDSubBookTypeField.TagId).flatMap(f=>MDSubBookTypeField.decode(f)),
        myFields.get(MarketDepthField.TagId).flatMap(f=>MarketDepthField.decode(f)),
        myFields.get(MDFeedTypeField.TagId).flatMap(f=>MDFeedTypeField.decode(f)),
        myFields.get(RefreshIndicatorField.TagId).flatMap(f=>RefreshIndicatorField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(MDReqIDField.TagId).flatMap(f=>MDReqIDField.decode(f)),
        myFields.get(MDStreamIDField.TagId).flatMap(f=>MDStreamIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(FinancialStatusField.TagId).flatMap(f=>FinancialStatusField.decode(f)),
        myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
        myFields.get(NetChgPrevDayField.TagId).flatMap(f=>NetChgPrevDayField.decode(f)),
        MDFullGrpComponent.decode(flds, startPos).get,
        myFields.get(ApplQueueDepthField.TagId).flatMap(f=>ApplQueueDepthField.decode(f)),
        myFields.get(ApplQueueResolutionField.TagId).flatMap(f=>ApplQueueResolutionField.decode(f)),
        RoutingGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     
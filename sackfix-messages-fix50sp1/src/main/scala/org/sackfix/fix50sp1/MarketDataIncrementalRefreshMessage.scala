package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class MarketDataIncrementalRefreshMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                               mDBookTypeField:Option[MDBookTypeField]=None,
                                               mDFeedTypeField:Option[MDFeedTypeField]=None,
                                               tradeDateField:Option[TradeDateField]=None,
                                               mDReqIDField:Option[MDReqIDField]=None,
                                               mDIncGrpComponent:MDIncGrpComponent,
                                               applQueueDepthField:Option[ApplQueueDepthField]=None,
                                               applQueueResolutionField:Option[ApplQueueResolutionField]=None,
                                               routingGrpComponent:Option[RoutingGrpComponent]=None) extends SfFixMessageBody("X")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    mDBookTypeField.foreach(fmt(b,_))
    mDFeedTypeField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    mDReqIDField.foreach(fmt(b,_))
    fmt(b,mDIncGrpComponent)
    applQueueDepthField.foreach(fmt(b,_))
    applQueueResolutionField.foreach(fmt(b,_))
    routingGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object MarketDataIncrementalRefreshMessage extends SfFixMessageDecoder {
  val MsgType="X"
  val MsgName="MarketDataIncrementalRefresh"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || MDIncGrpComponent.isMandatoryField(tagId) || RoutingGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MDBookTypeField.TagId, MDFeedTypeField.TagId, TradeDateField.TagId, MDReqIDField.TagId, ApplQueueDepthField.TagId, 
    ApplQueueResolutionField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || MDIncGrpComponent.isOptionalField(tagId) || RoutingGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || MDIncGrpComponent.isFieldOf(tagId) || RoutingGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDataIncrementalRefreshMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(MDBookTypeField.TagId).flatMap(f=>MDBookTypeField.decode(f)),
        myFields.get(MDFeedTypeField.TagId).flatMap(f=>MDFeedTypeField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(MDReqIDField.TagId).flatMap(f=>MDReqIDField.decode(f)),
        MDIncGrpComponent.decode(flds, startPos).get,
        myFields.get(ApplQueueDepthField.TagId).flatMap(f=>ApplQueueDepthField.decode(f)),
        myFields.get(ApplQueueResolutionField.TagId).flatMap(f=>ApplQueueResolutionField.decode(f)),
        RoutingGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     